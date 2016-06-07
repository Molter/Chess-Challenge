package br.com.gabrielmolter.chesschallenge.tests;

import br.com.gabrielmolter.chesschallenge.Pieces.BishopPiece;
import br.com.gabrielmolter.chesschallenge.Pieces.KnightPiece;
import br.com.gabrielmolter.chesschallenge.Pieces.QueenPiece;
import br.com.gabrielmolter.chesschallenge.Pieces.RookPiece;
import br.com.gabrielmolter.chesschallenge.board.Board;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Gabriel Molter on 01/06/2016 at 12:33 BRT.
 */
public class AllocationTests {

    private Board mBoard;

    @Before
    public void setUp(){
        mBoard = new Board(8, 8);
    }
    
    @After
    public void tearDown(){
        mBoard.displayBoard();
    }


    @Test
    public void validateAllocationMiddleBishopPiece(){

        mBoard.allocatePiece(4,3, new BishopPiece());
        assertTrue(!mBoard.getPiece(0,7).isEmpty());
        assertTrue(!mBoard.getPiece(1,0).isEmpty());
        assertTrue(!mBoard.getPiece(1,6).isEmpty());
        assertTrue(!mBoard.getPiece(2,1).isEmpty());
        assertTrue(!mBoard.getPiece(2,5).isEmpty());
        assertTrue(!mBoard.getPiece(3,2).isEmpty());
        assertTrue(!mBoard.getPiece(3,4).isEmpty());


        assertTrue(!mBoard.getPiece(7,0).isEmpty());
        assertTrue(!mBoard.getPiece(7,6).isEmpty());
        assertTrue(!mBoard.getPiece(6,1).isEmpty());
        assertTrue(!mBoard.getPiece(6,5).isEmpty());
        assertTrue(!mBoard.getPiece(5,2).isEmpty());
        assertTrue(!mBoard.getPiece(5,4).isEmpty());

    }

    @Test
    public void validateAllocationMiddleQueenPiece(){

        mBoard.allocatePiece(4,3, new QueenPiece());

        assertTrue(!mBoard.getPiece(0,7).isEmpty());
        assertTrue(!mBoard.getPiece(1,0).isEmpty());
        assertTrue(!mBoard.getPiece(1,6).isEmpty());
        assertTrue(!mBoard.getPiece(2,1).isEmpty());
        assertTrue(!mBoard.getPiece(2,5).isEmpty());
        assertTrue(!mBoard.getPiece(3,2).isEmpty());
        assertTrue(!mBoard.getPiece(3,4).isEmpty());


        assertTrue(!mBoard.getPiece(7,0).isEmpty());
        assertTrue(!mBoard.getPiece(7,6).isEmpty());
        assertTrue(!mBoard.getPiece(6,1).isEmpty());
        assertTrue(!mBoard.getPiece(6,5).isEmpty());
        assertTrue(!mBoard.getPiece(5,2).isEmpty());
        assertTrue(!mBoard.getPiece(5,4).isEmpty());


        assertTrue(!mBoard.getPiece(0,3).isEmpty());
        assertTrue(!mBoard.getPiece(1,3).isEmpty());
        assertTrue(!mBoard.getPiece(2,3).isEmpty());
        assertTrue(!mBoard.getPiece(3,3).isEmpty());
        assertTrue(!mBoard.getPiece(4,3).isEmpty());
        assertTrue(!mBoard.getPiece(5,3).isEmpty());
        assertTrue(!mBoard.getPiece(6,3).isEmpty());
        assertTrue(!mBoard.getPiece(7,3).isEmpty());

        assertTrue(!mBoard.getPiece(4,0).isEmpty());
        assertTrue(!mBoard.getPiece(4,1).isEmpty());
        assertTrue(!mBoard.getPiece(4,2).isEmpty());
        assertTrue(!mBoard.getPiece(4,3).isEmpty());
        assertTrue(!mBoard.getPiece(4,4).isEmpty());
        assertTrue(!mBoard.getPiece(4,5).isEmpty());
        assertTrue(!mBoard.getPiece(4,6).isEmpty());
        assertTrue(!mBoard.getPiece(4,7).isEmpty());

    }

    @Test
    public void validateAllocationMiddleRookPiece(){

        mBoard.allocatePiece(4,3, new RookPiece());

        assertTrue(!mBoard.getPiece(0,3).isEmpty());
        assertTrue(!mBoard.getPiece(1,3).isEmpty());
        assertTrue(!mBoard.getPiece(2,3).isEmpty());
        assertTrue(!mBoard.getPiece(3,3).isEmpty());
        assertTrue(!mBoard.getPiece(4,3).isEmpty());
        assertTrue(!mBoard.getPiece(5,3).isEmpty());
        assertTrue(!mBoard.getPiece(6,3).isEmpty());
        assertTrue(!mBoard.getPiece(7,3).isEmpty());

        assertTrue(!mBoard.getPiece(4,0).isEmpty());
        assertTrue(!mBoard.getPiece(4,1).isEmpty());
        assertTrue(!mBoard.getPiece(4,2).isEmpty());
        assertTrue(!mBoard.getPiece(4,3).isEmpty());
        assertTrue(!mBoard.getPiece(4,4).isEmpty());
        assertTrue(!mBoard.getPiece(4,5).isEmpty());
        assertTrue(!mBoard.getPiece(4,6).isEmpty());
        assertTrue(!mBoard.getPiece(4,7).isEmpty());

    }


}
