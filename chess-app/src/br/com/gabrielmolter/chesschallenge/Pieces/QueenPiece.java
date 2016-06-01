package br.com.gabrielmolter.chesschallenge.Pieces;

import br.com.gabrielmolter.chesschallenge.board.Allocatable;
import java.util.EnumSet;
import static br.com.gabrielmolter.chesschallenge.board.Allocatable.PieceRule.*;

/**
 * Created by Gabriel Molter on 31/05/2016 at 23:09 BRT.
 */
public class QueenPiece implements Allocatable{

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public EnumSet<PieceRule> getRules() {
        return EnumSet.of(NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST);
    }
}
