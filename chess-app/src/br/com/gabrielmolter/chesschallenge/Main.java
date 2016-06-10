package br.com.gabrielmolter.chesschallenge;

import br.com.gabrielmolter.chesschallenge.Pieces.KingPiece;
import br.com.gabrielmolter.chesschallenge.Pieces.RookPiece;
import br.com.gabrielmolter.chesschallenge.board.Allocatable;
import br.com.gabrielmolter.chesschallenge.board.BoardAllocator;

import java.util.ArrayList;

/**
 * Created by Gabriel Molter on 30/05/2016 at 21:34 at 21:35 BRT.
 */

public class Main {
    public static void main(String args[]){

        ArrayList<Allocatable> pieces = new ArrayList<>();
        pieces.add(new KingPiece());
        pieces.add(new KingPiece());

        BoardAllocator boardAllocator = new BoardAllocator(3, 2);
        boardAllocator.definePieceSet(pieces);

        boardAllocator.start();
        boardAllocator.displayCompletedBoards();

    }
}
