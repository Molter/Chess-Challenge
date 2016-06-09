package br.com.gabrielmolter.chesschallenge.Pieces;

import br.com.gabrielmolter.chesschallenge.board.Allocatable;

import java.util.EnumSet;

/**
 * Created by Gabriel Molter on 31/05/2016 at 01:22 BRT.
 */
public class EmptySpace  implements Allocatable {

    private boolean isEmpty = true;
    private int mRow;
    private int mColumn;

    public EmptySpace(){}

    public EmptySpace(int row, int column){
        setPosition(row, column);
    }



    @Override
    public boolean isEmpty(){
        return isEmpty;
    }

    @Override
    public void fillSpace() {
        isEmpty = false;
    }

    @Override
    public EnumSet<PieceRule> getRules() {
        return EnumSet.of(PieceRule.NONE);
    }

    @Override
    public String getDisplayType() {
        if(isEmpty)
            return "E";
        else
            return "I";
    }

    @Override
    public int getRow() {
        return mRow;
    }

    @Override
    public int getColumn() {
        return mColumn;
    }

    @Override
    public void setPosition(int row, int column) {
        mRow = row;
        mColumn = column;
    }

    @Override
    public Allocatable createCopy() {
        EmptySpace piece = new EmptySpace();
        piece.mRow = mRow;
        piece.mColumn = mColumn;
        piece.isEmpty = isEmpty;

        return piece;
    }
}
