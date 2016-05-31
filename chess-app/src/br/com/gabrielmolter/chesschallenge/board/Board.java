package br.com.gabrielmolter.chesschallenge.board;

import java.util.ArrayList;

/**
 * Created by Gabriel Molter on 30/05/2016 at 21:57 BRT.
 */
public class Board {

    private int mRows;
    private int mColumns;

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
                row.add(new EmptySpace());
            }
            mMatrix.add(row);
        }

    }

    /**
     * Main Board matrix
     */
    public ArrayList<ArrayList<Allocatable>> getBoard() {
        return mMatrix;
    }

    public int getNumberOfRows() {
        return mRows;
    }

    public int getNumberOfColumns() {
        return mColumns;
    }

    /**
     * Set a piece into a specific position
     * @param x Row
     * @param y Column
     * @param pieceToInsert Piece to be inserted
     */
    public void setPiece(int x, int y, Allocatable pieceToInsert){
        try{
            mMatrix.get(x).set(y, pieceToInsert);
        }catch (IndexOutOfBoundsException e){
            System.out.println("x = [" + x + "], y = [" + y + "], pieceToInsert = [" + pieceToInsert + "]");
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
}
