package br.com.gabrielmolter.chesschallenge.board;

import br.com.gabrielmolter.chesschallenge.Pieces.EmptySpace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel Molter on 30/05/2016 at 21:57 BRT.
 * Main chess board class
 */
public class Board {

    private int mRows;
    private int mColumns;

    private PieceBoardAllocator mAllocator;

    private List<List<Allocatable>> mMatrix = new ArrayList<>();
    public boolean isCompleted = false;


    /**
     * Constructor of the Board
     * @param rows Rows
     * @param columns Columns
     */
    public Board (int rows, int columns){
        this.mRows = rows;
        this.mColumns = columns;

        for (int i = 0; i < rows; i++) {
            ArrayList<Allocatable> row = new ArrayList<>();

            for (int j = 0; j < columns; j++) {
                row.add(new EmptySpace(i, j));
            }
            mMatrix.add(row);
        }

        mAllocator = new PieceBoardAllocator(this);
    }

    /**
     * Private constructor to avoid overhead of recreating the board array matrix used on the copy method
     * @param rows
     * @param columns
     * @param doNotRecreateEmptySpaces
     */
    public Board (int rows, int columns, boolean doNotRecreateEmptySpaces){
        this.mRows = rows;
        this.mColumns = columns;

        mAllocator = new PieceBoardAllocator(this);
    }

    /**
     * Main Board matrix
     */
    public List<List<Allocatable>> getBoard() {
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
    protected void setPiece(int row, int column, Allocatable pieceToInsert){

        mMatrix.get(row).set(column, pieceToInsert);
        pieceToInsert.setPosition(row, column);

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
     * @return Piece was allocated?
     */
    public boolean allocatePiece(int row, int column, Allocatable piece){
        return mAllocator.allocatePiece(row, column, piece);
    }

    /**
     * New Board Object with the same properties than old one.
     * @return
     */
    public Board createCopy() {

        Board board = new Board(mRows, mColumns, true);

        for (int i = 0; i < mRows; i++) {
            ArrayList<Allocatable> row = new ArrayList<>();

            for (int j = 0; j < mColumns; j++) {
                row.add(mMatrix.get(i).get(j).createCopy());
            }

            board.mMatrix.add(row);
        }

        return board;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Board)){
            return false;
        }
        Board subject = (Board) obj;
        //all boards should be equal size
        if(!(subject.getNumberOfColumns() == mColumns && subject.getNumberOfRows() == mRows)){
            return false;
        }

        // Compares cell Allocation
        for (int i = 0; i < mRows; i++) {

            for (int j = 0; j < mColumns; j++) {

                if (!(mMatrix.get(i).get(j).getClass() ==  subject.getPiece(i, j).getClass())){
                    return false;
                }
            }
        }
        return true;
    }
}
