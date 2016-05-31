package br.com.gabrielmolter.chesschallenge.board;

/**
 * Created by Gabriel Molter on 31/05/2016 at 01:22 BRT.
 */
public class EmptySpace  implements Allocatable{

    private boolean isEmpty = true;

    @Override
    public boolean isEmpty() {
        return this.isEmpty;
    }
}
