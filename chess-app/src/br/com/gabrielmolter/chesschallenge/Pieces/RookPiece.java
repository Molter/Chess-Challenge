package br.com.gabrielmolter.chesschallenge.Pieces;

import br.com.gabrielmolter.chesschallenge.board.Allocatable;

import java.util.EnumSet;

import static br.com.gabrielmolter.chesschallenge.board.Allocatable.PieceRule.*;

/**
 * Created by Gabriel Molter on 31/05/2016 at 23:12 BRT.
 */
public class RookPiece implements Allocatable {

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
        return EnumSet.of(NORTH, EAST, WEST, SOUTH);
    }

    @Override
    public String getDisplayType() {
        return "RO";
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
}
