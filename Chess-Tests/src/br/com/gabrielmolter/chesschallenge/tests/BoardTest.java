package br.com.gabrielmolter.chesschallenge.tests;

import br.com.gabrielmolter.chesschallenge.Pieces.KingPiece;
import br.com.gabrielmolter.chesschallenge.board.Allocatable;
import br.com.gabrielmolter.chesschallenge.board.Board;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Gabriel Molter on 30/05/2016 at 23:58 BRT.
 */
public class BoardTest {

    private int mBoardSize;
    private Board mBoard;

    @Before
    public void setUp(){
        Random rand = new Random();
        mBoardSize = rand.nextInt(10);
        mBoard = new Board(mBoardSize, mBoardSize);
    }

    @Test
    public void validateBoardSizes(){
        assertEquals(mBoardSize, mBoard.getxSize());

        assertEquals(mBoardSize, mBoard.getySize());
        // validating x size
        assertEquals(mBoardSize, mBoard.getBoard().size());
        //validating y size
        assertEquals(mBoardSize, mBoard.getBoard().get(0).size());
    }

    @Test
    public void validateBoardEmptyness(){
        for (ArrayList<Allocatable> row : mBoard.getBoard()){
            for (Allocatable cell :
                    row) {
                assertTrue(cell.isEmpty());
            }
        }
    }

    @Test
    public void allocatePiece(){
        Allocatable piece =  new KingPiece();

        mBoard.setPiece(0, 0, piece);
        assertEquals(mBoard.getPiece(0, 0), piece);

        mBoard.setPiece(0, mBoardSize - 1, piece);
        assertEquals(mBoard.getPiece(0, mBoardSize - 1), piece);

        mBoard.setPiece(mBoardSize - 1, 0, piece);
        assertEquals(mBoard.getPiece(mBoardSize - 1, 0), piece);
    }



}
