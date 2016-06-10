package br.com.gabrielmolter.chesschallenge;

import br.com.gabrielmolter.chesschallenge.Pieces.*;
import br.com.gabrielmolter.chesschallenge.board.Allocatable;
import br.com.gabrielmolter.chesschallenge.board.BoardAllocator;

import java.util.ArrayList;

/**
 * Created by Gabriel Molter on 30/05/2016 at 21:34 at 21:35 BRT.
 */

public class ChessApp {
    public static void main(String args[]){

        if (args.length != 7){
            showHelp();
            return;
        }


        int rows = tryParce(args[0], "Rows");
        int columns = tryParce(args[1], "Columns");
        int kings = tryParce(args[2], "Kings");
        int queens = tryParce(args[3], "Queens");
        int bishops = tryParce(args[4], "Bishops");
        int rooks = tryParce(args[5], "Rooks");
        int knights = tryParce(args[6], "Knights");

        BoardAllocator boardAllocator = new BoardAllocator(rows, columns);

        ArrayList<Allocatable> pieces = new ArrayList<>();
        for (int i = 0; i < kings; i++) {
            pieces.add(new KingPiece());

        }
        for (int i = 0; i < queens; i++) {
            pieces.add(new QueenPiece());

        }
        for (int i = 0; i < bishops; i++) {
            pieces.add(new BishopPiece());

        }
        for (int i = 0; i < rooks; i++) {
            pieces.add(new RookPiece());

        }
        for (int i = 0; i < knights; i++) {
            pieces.add(new KnightPiece());

        }

        boardAllocator.definePieceSet(pieces);

        boardAllocator.start();
        boardAllocator.displayCompletedBoards();

    }

    private static int tryParce(String subject,  String parameter) {
        try{
            int value = Integer.parseInt(subject);
            return  value;

        }catch (NumberFormatException e){
            System.out.println("Incorrect input value, assuming zero");
            System.out.println(parameter + " = " + subject );
            return 0;
        }
    }

    private static void showHelp() {
        System.out.println("Please provide the arguments in the following order: ");
        System.out.println("Number of board rows, Number of board Columns, Number of Kings, Number of Queens, Number of Bishops , Number of Rooks, Number of Knights");
        System.out.println("Example:");
        System.out.println("ChessApp 7 7 2 2 2 0 1");
    }
}
