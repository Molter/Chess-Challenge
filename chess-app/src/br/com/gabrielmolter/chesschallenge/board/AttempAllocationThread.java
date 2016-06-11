package br.com.gabrielmolter.chesschallenge.board;

import java.util.ArrayList;

/**
 * Created by Gabriel Molter on 10/06/2016 at 21:07 BRT.
 */
public class AttempAllocationThread implements Runnable {

    BoardAllocator mBoardAllocator;
    int row;
    int column;
    Allocatable pieceToBeIncluded;
    ArrayList<Allocatable> pieces;
    Board board;


    public AttempAllocationThread(BoardAllocator boardAllocator, int row, int column, Allocatable pieceToBeIncluded, ArrayList<Allocatable> pieces, Board board){
        mBoardAllocator = boardAllocator;
        this.row = row;
        this.column = column;
        this.pieceToBeIncluded = pieceToBeIncluded;
        this.pieces = pieces;
        this.board = board;
    }

    @Override
    public void run() {
        attemptAllocation(row, column, pieceToBeIncluded, pieces, board);
    }

    /**
     * Attempt to allocate a Piece in a cell
     * @param row Row
     * @param column Column
     * @param pieceToBeIncluded Piece
     * @param pieces Remaining Pieces
     * @param board Board
     * @return Board with the new piece
     */
    private Board attemptAllocation(int row, int column, Allocatable pieceToBeIncluded, ArrayList<Allocatable> pieces, Board board) {

        if(!board.getPiece(row, column).isEmpty()) {
            return  board;
        }

        Board tempBoard = board.createCopy();
        boolean isValidAllocation = tempBoard.allocatePiece(row, column, pieceToBeIncluded);
        if (!isValidAllocation){
            return board;
        }
        board = tempBoard;

        //allocate the piece in the empty space
        pieces.remove(pieceToBeIncluded);


        //all pieces allocated? Board is completed
        if(pieces.size() == 0){
            board.isCompleted = true;
            return  board;
        }

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < board.getNumberOfRows(); i++) {
            for (int j = 0; j < board.getNumberOfColumns(); j++){
                if(tempBoard.getPiece(i, j).isEmpty()){
                    for (int k = 0; k < pieces.size(); k++) {
                        //create new threds here
                        AttempAllocationThread runnable = new AttempAllocationThread(mBoardAllocator, i, j, pieces.get(k), new ArrayList<>(pieces), tempBoard.createCopy());
                        Thread t = new Thread(runnable);
                        threads.add(t);
                        t.start();
                    }
                }
            }
        }

        // wait untill all threads complete
        for (Thread t :
                threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return  board;
    }
}
