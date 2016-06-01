package br.com.gabrielmolter.chesschallenge.Pieces;

import br.com.gabrielmolter.chesschallenge.board.Allocatable;
import java.util.EnumSet;
import static br.com.gabrielmolter.chesschallenge.board.Allocatable.PieceRule.KING;

/**
 * Created by Gabriel Molter on 31/05/2016 at 02:34 BRT.
 */
public class KingPiece  implements Allocatable{

    private boolean isEmpty = false;

    @Override
    public boolean isEmpty() {
        return this.isEmpty;
    }

    @Override
    public EnumSet<PieceRule> getRules() {
        return  EnumSet.of(KING);
    }
}
