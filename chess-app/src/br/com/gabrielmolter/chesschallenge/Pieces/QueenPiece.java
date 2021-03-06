package br.com.gabrielmolter.chesschallenge.Pieces;

import br.com.gabrielmolter.chesschallenge.board.Allocatable;

import java.util.EnumSet;

import static br.com.gabrielmolter.chesschallenge.board.Allocatable.PieceRule.*;

/**
 * Created by Gabriel Molter on 31/05/2016 at 23:09 BRT.
 */
public class QueenPiece implements Allocatable{

    private int mRow;
    private int mColumn;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void fillSpace() {
        throw  new InvalidAllocationException();
    }

    @Override
    public EnumSet<PieceRule> getRules() {
        return EnumSet.of(NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST);
    }

    @Override
    public String getDisplayType() {
        return "QN";
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
        QueenPiece piece = new QueenPiece();
        piece.mRow = mRow;
        piece.mColumn = mColumn;

        return piece;
    }
}
