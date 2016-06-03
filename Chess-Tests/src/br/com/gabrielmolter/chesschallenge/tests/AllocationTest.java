package br.com.gabrielmolter.chesschallenge.tests;

import br.com.gabrielmolter.chesschallenge.Pieces.KingPiece;
import br.com.gabrielmolter.chesschallenge.board.Board;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Gabriel Molter on 01/06/2016 at 12:33 BRT.
 */
public class AllocationTest {

    private Board mBoard;

    @Test
    public void validateAllocationFirstLeft(){
        Board board = new Board(3, 3);
        board.allocatePiece(0,0, new KingPiece());
        board.displayFreeResults();

        assertTrue(!board.getPiece(0,0).isEmpty());
        assertTrue(!board.getPiece(0,1).isEmpty());
        assertTrue(board.getPiece(0,2).isEmpty());

        assertTrue(!board.getPiece(1,0).isEmpty());
        assertTrue(!board.getPiece(1,1).isEmpty());
        assertTrue(board.getPiece(1,2).isEmpty());

        assertTrue(board.getPiece(2,0).isEmpty());
        assertTrue(board.getPiece(2,1).isEmpty());
        assertTrue(board.getPiece(2,2).isEmpty());
    }

    @Test
    public void validateAllocationFirstMiddle(){
        Board board = new Board(3, 3);
        board.allocatePiece(0,1, new KingPiece());
        board.displayFreeResults();

        assertTrue(!board.getPiece(0,0).isEmpty());
        assertTrue(!board.getPiece(0,1).isEmpty());
        assertTrue(!board.getPiece(0,2).isEmpty());

        assertTrue(!board.getPiece(1,0).isEmpty());
        assertTrue(!board.getPiece(1,1).isEmpty());
        assertTrue(!board.getPiece(1,2).isEmpty());

        assertTrue(board.getPiece(2,0).isEmpty());
        assertTrue(board.getPiece(2,1).isEmpty());
        assertTrue(board.getPiece(2,2).isEmpty());
    }

    @Test
    public void validateAllocationFirstRight(){
        Board board = new Board(3, 3);
        board.allocatePiece(0,2, new KingPiece());
        board.displayFreeResults();

        assertTrue(board.getPiece(0,0).isEmpty());
        assertTrue(!board.getPiece(0,1).isEmpty());
        assertTrue(!board.getPiece(0,2).isEmpty());

        assertTrue(board.getPiece(1,0).isEmpty());
        assertTrue(!board.getPiece(1,1).isEmpty());
        assertTrue(!board.getPiece(1,2).isEmpty());

        assertTrue(!board.getPiece(2,0).isEmpty());
        assertTrue(!board.getPiece(2,1).isEmpty());
        assertTrue(!board.getPiece(2,2).isEmpty());
    }

    @Test
    public void validateAllocationMidleLeft(){
        Board board = new Board(3, 3);
        board.allocatePiece(1,0, new KingPiece());
        board.displayFreeResults();

        assertTrue(!board.getPiece(0,0).isEmpty());
        assertTrue(!board.getPiece(0,1).isEmpty());
        assertTrue(board.getPiece(0,2).isEmpty());

        assertTrue(!board.getPiece(1,0).isEmpty());
        assertTrue(!board.getPiece(1,1).isEmpty());
        assertTrue(board.getPiece(1,2).isEmpty());

        assertTrue(!board.getPiece(2,0).isEmpty());
        assertTrue(!board.getPiece(2,1).isEmpty());
        assertTrue(board.getPiece(2,2).isEmpty());
    }


    @Test
    public void validateAllocationMiddleMiddle(){
        Board board = new Board(3, 3);
        board.allocatePiece(1,1, new KingPiece());
        board.displayFreeResults();

        assertFalse(board.getPiece(0,0).isEmpty());
        assertFalse(board.getPiece(0,1).isEmpty());
        assertFalse(board.getPiece(0,2).isEmpty());

        assertFalse(board.getPiece(1,0).isEmpty());
        assertFalse(board.getPiece(1,1).isEmpty());
        assertFalse(board.getPiece(1,2).isEmpty());

        assertFalse(board.getPiece(2,0).isEmpty());
        assertFalse(board.getPiece(2,1).isEmpty());
        assertFalse(board.getPiece(2,2).isEmpty());
    }

    @Test
    public void validateAllocationMidleRight(){
        Board board = new Board(3, 3);
        board.allocatePiece(1,2, new KingPiece());
        board.displayFreeResults();

        assertTrue(board.getPiece(0,0).isEmpty());
        assertTrue(!board.getPiece(0,1).isEmpty());
        assertTrue(!board.getPiece(0,2).isEmpty());

        assertTrue(board.getPiece(1,0).isEmpty());
        assertTrue(!board.getPiece(1,1).isEmpty());
        assertTrue(!board.getPiece(1,2).isEmpty());

        assertTrue(board.getPiece(2,0).isEmpty());
        assertTrue(!board.getPiece(2,1).isEmpty());
        assertTrue(!board.getPiece(2,2).isEmpty());
    }

    @Test
    public void validateAllocationBottonRight(){
        Board board = new Board(3, 3);
        board.allocatePiece(2,2, new KingPiece());
        board.displayFreeResults();

        assertTrue(board.getPiece(0,0).isEmpty());
        assertTrue(board.getPiece(0,1).isEmpty());
        assertTrue(board.getPiece(0,2).isEmpty());

        assertTrue(board.getPiece(1,0).isEmpty());
        assertTrue(!board.getPiece(1,1).isEmpty());
        assertTrue(!board.getPiece(1,2).isEmpty());

        assertTrue(!board.getPiece(2,0).isEmpty());
        assertTrue(!board.getPiece(2,1).isEmpty());
        assertTrue(!board.getPiece(2,2).isEmpty());
    }


    @Test
    public void validateAllocationBottonLeft(){
        Board board = new Board(3, 3);
        board.allocatePiece(2,0, new KingPiece());
        board.displayFreeResults();

        assertTrue(board.getPiece(0,0).isEmpty());
        assertTrue(board.getPiece(0,1).isEmpty());
        assertTrue(board.getPiece(0,2).isEmpty());

        assertTrue(!board.getPiece(1,0).isEmpty());
        assertTrue(!board.getPiece(1,1).isEmpty());
        assertTrue(board.getPiece(1,2).isEmpty());

        assertTrue(!board.getPiece(2,0).isEmpty());
        assertTrue(!board.getPiece(2,1).isEmpty());
        assertTrue(board.getPiece(2,2).isEmpty());
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
