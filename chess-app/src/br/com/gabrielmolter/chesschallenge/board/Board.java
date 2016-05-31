package br.com.gabrielmolter.chesschallenge.board;

import java.util.ArrayList;

/**
 * Created by Gabriel Molter on 30/05/2016 at 21:57 BRT.
 */
public class Board {

    private int xSize;
    private int ySize;

    private ArrayList<ArrayList<Allocatable>>  mMatrix = new ArrayList<>();


    /**
     * Constructor of the Board
     * @param x Height
     * @param y Width
     */
    public Board (int x, int y){
        this.xSize = x;
        this.ySize = y;

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

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }
}
