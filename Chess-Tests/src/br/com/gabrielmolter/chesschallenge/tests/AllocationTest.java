package br.com.gabrielmolter.chesschallenge.tests;

import br.com.gabrielmolter.chesschallenge.Pieces.KingPiece;
import br.com.gabrielmolter.chesschallenge.board.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Gabriel Molter on 01/06/2016 at 12:33 BRT.
 */
public class AllocationTest {

    private Board mBoard;

    @Before
    public void setUp(){
        mBoard = new Board(3, 3);
    }
    
    @After
    public void tearDown(){
        mBoard.displayFreeResults();
    }


    @Test
    public void validateAllocationFirstLeft(){
       
        mBoard.allocatePiece(0,0, new KingPiece());

        assertTrue(!mBoard.getPiece(0,0).isEmpty());
        assertTrue(!mBoard.getPiece(0,1).isEmpty());
        assertTrue(mBoard.getPiece(0,2).isEmpty());

        assertTrue(!mBoard.getPiece(1,0).isEmpty());
        assertTrue(!mBoard.getPiece(1,1).isEmpty());
        assertTrue(mBoard.getPiece(1,2).isEmpty());

        assertTrue(mBoard.getPiece(2,0).isEmpty());
        assertTrue(mBoard.getPiece(2,1).isEmpty());
        assertTrue(mBoard.getPiece(2,2).isEmpty());
    }

    @Test
    public void validateAllocationFirstMiddle(){
        Board board = new Board(3, 3);
        mBoard.allocatePiece(0,1, new KingPiece());
        mBoard.displayFreeResults();

        assertTrue(!mBoard.getPiece(0,0).isEmpty());
        assertTrue(!mBoard.getPiece(0,1).isEmpty());
        assertTrue(!mBoard.getPiece(0,2).isEmpty());

        assertTrue(!mBoard.getPiece(1,0).isEmpty());
        assertTrue(!mBoard.getPiece(1,1).isEmpty());
        assertTrue(!mBoard.getPiece(1,2).isEmpty());

        assertTrue(mBoard.getPiece(2,0).isEmpty());
        assertTrue(mBoard.getPiece(2,1).isEmpty());
        assertTrue(mBoard.getPiece(2,2).isEmpty());
    }

    @Test
    public void validateAllocationFirstRight(){
        Board board = new Board(3, 3);
        mBoard.allocatePiece(0,2, new KingPiece());
        mBoard.displayFreeResults();

        assertTrue(mBoard.getPiece(0,0).isEmpty());
        assertTrue(!mBoard.getPiece(0,1).isEmpty());
        assertTrue(!mBoard.getPiece(0,2).isEmpty());

        assertTrue(mBoard.getPiece(1,0).isEmpty());
        assertTrue(!mBoard.getPiece(1,1).isEmpty());
        assertTrue(!mBoard.getPiece(1,2).isEmpty());

        assertTrue(!mBoard.getPiece(2,0).isEmpty());
        assertTrue(!mBoard.getPiece(2,1).isEmpty());
        assertTrue(!mBoard.getPiece(2,2).isEmpty());
    }

    @Test
    public void validateAllocationMidleLeft(){
        Board board = new Board(3, 3);
        mBoard.allocatePiece(1,0, new KingPiece());
        mBoard.displayFreeResults();

        assertTrue(!mBoard.getPiece(0,0).isEmpty());
        assertTrue(!mBoard.getPiece(0,1).isEmpty());
        assertTrue(mBoard.getPiece(0,2).isEmpty());

        assertTrue(!mBoard.getPiece(1,0).isEmpty());
        assertTrue(!mBoard.getPiece(1,1).isEmpty());
        assertTrue(mBoard.getPiece(1,2).isEmpty());

        assertTrue(!mBoard.getPiece(2,0).isEmpty());
        assertTrue(!mBoard.getPiece(2,1).isEmpty());
        assertTrue(mBoard.getPiece(2,2).isEmpty());
    }


    @Test
    public void validateAllocationMiddleMiddle(){
        Board board = new Board(3, 3);
        mBoard.allocatePiece(1,1, new KingPiece());
        mBoard.displayFreeResults();

        assertFalse(mBoard.getPiece(0,0).isEmpty());
        assertFalse(mBoard.getPiece(0,1).isEmpty());
        assertFalse(mBoard.getPiece(0,2).isEmpty());

        assertFalse(mBoard.getPiece(1,0).isEmpty());
        assertFalse(mBoard.getPiece(1,1).isEmpty());
        assertFalse(mBoard.getPiece(1,2).isEmpty());

        assertFalse(mBoard.getPiece(2,0).isEmpty());
        assertFalse(mBoard.getPiece(2,1).isEmpty());
        assertFalse(mBoard.getPiece(2,2).isEmpty());
    }

    @Test
    public void validateAllocationMidleRight(){
        Board board = new Board(3, 3);
        mBoard.allocatePiece(1,2, new KingPiece());
        mBoard.displayFreeResults();

        assertTrue(mBoard.getPiece(0,0).isEmpty());
        assertTrue(!mBoard.getPiece(0,1).isEmpty());
        assertTrue(!mBoard.getPiece(0,2).isEmpty());

        assertTrue(mBoard.getPiece(1,0).isEmpty());
        assertTrue(!mBoard.getPiece(1,1).isEmpty());
        assertTrue(!mBoard.getPiece(1,2).isEmpty());

        assertTrue(mBoard.getPiece(2,0).isEmpty());
        assertTrue(!mBoard.getPiece(2,1).isEmpty());
        assertTrue(!mBoard.getPiece(2,2).isEmpty());
    }

    @Test
    public void validateAllocationBottonRight(){
        Board board = new Board(3, 3);
        mBoard.allocatePiece(2,2, new KingPiece());
        mBoard.displayFreeResults();

        assertTrue(mBoard.getPiece(0,0).isEmpty());
        assertTrue(mBoard.getPiece(0,1).isEmpty());
        assertTrue(mBoard.getPiece(0,2).isEmpty());

        assertTrue(mBoard.getPiece(1,0).isEmpty());
        assertTrue(!mBoard.getPiece(1,1).isEmpty());
        assertTrue(!mBoard.getPiece(1,2).isEmpty());

        assertTrue(!mBoard.getPiece(2,0).isEmpty());
        assertTrue(!mBoard.getPiece(2,1).isEmpty());
        assertTrue(!mBoard.getPiece(2,2).isEmpty());
    }


    @Test
    public void validateAllocationBottonLeft(){
        Board board = new Board(3, 3);
        mBoard.allocatePiece(2,0, new KingPiece());
        mBoard.displayFreeResults();

        assertTrue(mBoard.getPiece(0,0).isEmpty());
        assertTrue(mBoard.getPiece(0,1).isEmpty());
        assertTrue(mBoard.getPiece(0,2).isEmpty());

        assertTrue(!mBoard.getPiece(1,0).isEmpty());
        assertTrue(!mBoard.getPiece(1,1).isEmpty());
        assertTrue(mBoard.getPiece(1,2).isEmpty());

        assertTrue(!mBoard.getPiece(2,0).isEmpty());
        assertTrue(!mBoard.getPiece(2,1).isEmpty());
        assertTrue(mBoard.getPiece(2,2).isEmpty());
    }

    @Test
    public void validateAllocationBottonMiddle(){
        mBoard.allocatePiece(2,1, new KingPiece());
        mBoard.displayFreeResults();

        assertTrue(mBoard.getPiece(0,0).isEmpty());
        assertTrue(mBoard.getPiece(0,1).isEmpty());
        assertTrue(mBoard.getPiece(0,2).isEmpty());

        assertTrue(!mBoard.getPiece(1,0).isEmpty());
        assertTrue(!mBoard.getPiece(1,1).isEmpty());
        assertTrue(!mBoard.getPiece(1,2).isEmpty());

        assertTrue(!mBoard.getPiece(2,0).isEmpty());
        assertTrue(!mBoard.getPiece(2,1).isEmpty());
        assertTrue(!mBoard.getPiece(2,2).isEmpty());
    }
}
