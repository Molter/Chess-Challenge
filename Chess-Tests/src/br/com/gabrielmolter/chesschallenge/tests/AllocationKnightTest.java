package br.com.gabrielmolter.chesschallenge.tests;

import br.com.gabrielmolter.chesschallenge.Pieces.KnightPiece;
import br.com.gabrielmolter.chesschallenge.board.Board;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gabriel Molter on 01/06/2016 at 12:33 BRT.
 */
public class AllocationKnightTest {

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
    public void validateAllocationFirstLeft(){

        mBoard.allocatePiece(0,0, new KnightPiece());

        assertTrue(!mBoard.getPiece(2,1).isEmpty());
        assertTrue(!mBoard.getPiece(1, 2).isEmpty());

    }


    @Test
    public void validateAllocationMiddle(){

        mBoard.allocatePiece(4,3, new KnightPiece());

        assertTrue(!mBoard.getPiece(2,2).isEmpty());
        assertTrue(!mBoard.getPiece(2,4).isEmpty());

        assertTrue(!mBoard.getPiece(3,1).isEmpty());
        assertTrue(!mBoard.getPiece(3,5).isEmpty());

        assertTrue(!mBoard.getPiece(5, 1).isEmpty());
        assertTrue(!mBoard.getPiece(5, 5).isEmpty());

        assertTrue(!mBoard.getPiece(6,2).isEmpty());
        assertTrue(!mBoard.getPiece(6,4).isEmpty());

    }


}
