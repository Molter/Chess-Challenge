package br.com.gabrielmolter.chesschallenge.board;

import br.com.gabrielmolter.chesschallenge.Pieces.EmptySpace;

import java.util.ArrayList;

/**
 * Created by Gabriel Molter on 30/05/2016 at 21:57 BRT.
 * Main chess board class
 */
public class Board {

    private int mRows;
    private int mColumns;

    private PieceBoardAllocator mAllocator;

    private ArrayList<ArrayList<Allocatable>>  mMatrix = new ArrayList<>();



    /**
     * Constructor of the Board
     * @param x Rows
     * @param y Columns
     */
    public Board (int x, int y){
        this.mRows = x;
        this.mColumns = y;

        for (int i = 0; i < x; i++) {
            ArrayList<Allocatable> row = new ArrayList<>();

            for (int j = 0; j < y; j++) {
                row.add(new EmptySpace(i, j));
            }
            mMatrix.add(row);
        }

        mAllocator = new PieceBoardAllocator(this);
    }

    /**
     * Main Board matrix
     */
    public ArrayList<ArrayList<Allocatable>> getBoard() {
        return mMatrix;
    }

    /**
     * Get the total board rows
     * @return number of rows
     */
    public int getNumberOfRows() {
        return mRows;
    }

    /**
     * Get the total board columns
     * @return number of Columns
     */
    public int getNumberOfColumns() {
        return mColumns;
    }

    /**
     * Set a piece into a specific position
     * @param row Row
     * @param column Column
     * @param pieceToInsert Piece to be inserted
     */
    public void setPiece(int row, int column, Allocatable pieceToInsert){
        try{
            mMatrix.get(row).set(column, pieceToInsert);
            pieceToInsert.setPosition(row, column);
        }catch (IndexOutOfBoundsException e){
            System.out.println("x = [" + row + "], y = [" + column + "], pieceToInsert = [" + pieceToInsert + "]");
            System.out.println("Invalid Position");
            throw e;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * Return the piece at a specific position
     * @param x Row
     * @param y Column
     * @return Piece or Empty Space
     */
    public Allocatable getPiece(int x, int y){
        try{
            return mMatrix.get(x).get(y);
        }catch (IndexOutOfBoundsException e){
            System.out.println("x = [" + x + "], y = [" + y + "]");
            System.out.println("Invalid Position");
            throw e;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * Print the current board
     */
    public void displayBoard(){
        BoardDisplayer.showBoardStatus(this);
    }

    /**
     * Allocates a piece at a given  position on the board
     * @param row Row index
     * @param column Column Index
     * @param piece Allocable piece to be placed.
     */
    public void allocatePiece(int row, int column, Allocatable piece){
        mAllocator.allocatePiece(row, column, piece);
    }
}
