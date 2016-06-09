package br.com.gabrielmolter.chesschallenge.board;

import br.com.gabrielmolter.chesschallenge.Pieces.InvalidBoardSetupException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel Molter on 07/06/2016 at 01:27 BRT.
 */
public class BoardAllocator {

    private int mRows;
    private int mColumns;
    private Board mEmptyBoard;

    private List<Board> mCompletedBoards = new ArrayList<>();
    private List<Allocatable> mPieces = new ArrayList<>();

    /**
     * Contructor
     * @param rows
     * @param columns
     */
    public BoardAllocator(int rows, int columns) {
        mRows = rows;
        mColumns = columns;
        mEmptyBoard = new Board(rows, columns);
    }

    /**
     * Show all valid board configurations
     */
    public void displayCompletedBoards() {

        System.out.println("Total Valid boards = " + mCompletedBoards.size());

        for (Board board :
                mCompletedBoards) {
            board.displayBoard();
        }
    }

    /**
     * If at least one result is found the configuratio is valid
     * @return
     */
    public boolean isAnyConfigurationValid(){
        return mCompletedBoards.size() > 0;
    }

    /**
     * Allocate the places within the board
     * @param pieces
     */
    public void definePieceSet(List<Allocatable> pieces){
        mPieces = pieces;
    }

    /**
     * Start the allocation process
     */
    public void start() {

        if(mRows ==0 || mColumns == 0 || mPieces.size() == 0){
            throw new InvalidBoardSetupException();
        }

        Board currentBoardSet;
        for (int i = 0; i < mRows; i++) {

            for (int j = 0; j < mColumns; j++)
                for (int k = 0; k < mPieces.size(); k++) {
                    currentBoardSet = attemptAllocation(i, j, mPieces.get(k), new ArrayList<>(mPieces), mEmptyBoard.createCopy());

                    if (currentBoardSet.isCompleted) {
                        mCompletedBoards.add(currentBoardSet);
                    }

                }
        }
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

        //find next empty space, or return board if none
        Allocatable emptySpace = findNextFreeSpace(board);
        if(emptySpace == null){
            return  board;
        }
        board = attemptAllocation(emptySpace.getRow(), emptySpace.getColumn(), pieces.get(0), new ArrayList<>(pieces), board.createCopy());

        return  board;
    }

    /**
     * Find next free cell
     * @param board
     * @return Free Object
     */
    private Allocatable findNextFreeSpace(Board board) {
        for (int i = 0; i < mRows; i++) {
            for (int j = 0; j < mColumns; j++){
                if(board.getPiece(i, j).isEmpty()){
                    return board.getPiece(i, j);
                }
            }
        }
        return null;
    }

    /**
     * Number of valid configuration sets
     * @return
     */
    public int numberOfResults(){
        return mCompletedBoards.size();
    }
}

