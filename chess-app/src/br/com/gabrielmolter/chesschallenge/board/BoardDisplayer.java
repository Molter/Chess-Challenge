package br.com.gabrielmolter.chesschallenge.board;

import java.util.List;

/**
 * Created by Gabriel Molter on 01/06/2016 at 12:41 BRT.
 * Display the board into the console
 */
public class BoardDisplayer {


    /**
     * Prints the board into the console
     * @param board Board
     * @see Board
     */
    public static void showBoardStatus(Board board){
        System.out.println();
        for (List<Allocatable> row :
                board.getBoard()) {

            for (Allocatable cell :
                    row) {
                System.out.print("[ " + cell.getDisplayType() + "] ");
            }
            System.out.println();

        }
    }


}
