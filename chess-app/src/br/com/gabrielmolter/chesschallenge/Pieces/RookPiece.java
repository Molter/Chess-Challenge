package br.com.gabrielmolter.chesschallenge.Pieces;

import br.com.gabrielmolter.chesschallenge.board.Allocatable;

import java.util.EnumSet;

import static br.com.gabrielmolter.chesschallenge.board.Allocatable.PieceRule.*;

/**
 * Created by Gabriel Molter on 31/05/2016 at 23:12 BRT.
 */
public class RookPiece implements Allocatable {
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public EnumSet<PieceRule> getRules() {
        return EnumSet.of(NORTH, EAST, WEST, SOUTH);
    }
}
