package br.com.gabrielmolter.chesschallenge.board;

import java.util.ArrayList;

/**
 * Created by Gabriel Molter on 01/06/2016 at 12:41 BRT.
 */
public class BoardDisplayer {


    public static void showBoardStatus(Board board){
        System.out.println();
        for (ArrayList<Allocatable> row :
                board.getBoard()) {

            for (Allocatable cell :
                    row) {
                System.out.print("[ " + cell.getDisplayType() + "] ");
            }
            System.out.println();

        }
    }


}
