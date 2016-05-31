package br.com.gabrielmolter.chesschallenge.tests;

import br.com.gabrielmolter.chesschallenge.board.Board;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Gabriel Molter on 30/05/2016 at 23:58 BRT.
 */
public class BoardTest {

    @Test
    public void ValidateBoardSizes(){

        Random rand = new Random();
        int size = rand.nextInt(10);

        Board board = new Board(size, size);

        assertEquals(size, board.getxSize());

        assertEquals(size, board.getySize());

        // validating x size
        assertEquals(size, board.getBoard().size());

        //validating y size
        assertEquals(size, board.getBoard().get(0).size());

    }


}
