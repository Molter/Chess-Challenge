package br.com.gabrielmolter.chesschallenge.tests;

import br.com.gabrielmolter.chesschallenge.Pieces.KingPiece;
import br.com.gabrielmolter.chesschallenge.board.Allocatable;
import br.com.gabrielmolter.chesschallenge.board.Board;
import br.com.gabrielmolter.chesschallenge.board.BoardAllocator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gabriel Molter on 30/05/2016 at 23:58 BRT.
 */
public class MultipleAllocationsTest {

    private Board mBoard;
    private BoardAllocator mBoardAllocator;

    @Before
    public void setUp(){
        mBoardAllocator = new BoardAllocator(3, 3);
    }

    @After
    public void tearDown(){
        mBoardAllocator.displayCompletedBoards();
    }

    @Test
    public void allocatePieces(){

        mBoardAllocator.findAllocations( new ArrayList<Allocatable>() {{
            new KingPiece();
            new KingPiece();
            new KingPiece();
        }});

        assertTrue(mBoardAllocator.isConfigurationValid());

    }



}
