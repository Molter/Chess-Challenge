package br.com.gabrielmolter.chesschallenge.board;

import java.util.ArrayList;

import static br.com.gabrielmolter.chesschallenge.board.Allocatable.PieceRule.*;

/**
 * Created by Gabriel Molter on 31/05/2016 at 23:23 BRT.
 */
public class PieceBoardAllocator {

    private Board mBoard;

    private ArrayList<Allocatable> mNorthPieces = new ArrayList<>();
    private ArrayList<Allocatable> mNorthEastPieces = new ArrayList<>();
    private ArrayList<Allocatable> mNorthWestPieces = new ArrayList<>();
    private ArrayList<Allocatable> mEastPieces = new ArrayList<>();
    private ArrayList<Allocatable> mWeastPieces = new ArrayList<>();
    private ArrayList<Allocatable> mSouthPieces = new ArrayList<>();
    private ArrayList<Allocatable> mSouthEastPieces = new ArrayList<>();
    private ArrayList<Allocatable> mSouthWestPieces = new ArrayList<>();
    private ArrayList<Allocatable> mKingPieces = new ArrayList<>();
    private ArrayList<Allocatable> mKnightPieces = new ArrayList<>();


    public PieceBoardAllocator (Board board){
        mBoard = board;
    }

    public boolean allocatePiece(int row, int column, Allocatable piece){
        if(!mBoard.getPiece(row, column).isEmpty()){
            // not empty space
            return false;
        }

        mBoard.setPiece(row, column, piece);
        FlagAllInvalidSpaces(piece);

        return true;
    }



    private void FlagAllInvalidSpaces(Allocatable piece) {
        for (Allocatable.PieceRule rule: piece.getRules()){
            switch (rule){
                case NORTH:
                    fillSpaces(mNorthPieces);
                    break;
                case SOUTH:
                    findSpaces(SOUTH);
                    fillSpaces(mSouthPieces);
                    break;
                case EAST:
                    findSpaces(EAST);
                    fillSpaces(mEastPieces);
                    break;
                case WEST:
                    findSpaces(WEST);
                    fillSpaces(mWeastPieces);
                    break;
                case NORTHEAST:
                    findSpaces(NORTHEAST);
                    fillSpaces(mNorthEastPieces);
                    break;
                case NORTHWEST:
                    findSpaces(NORTHWEST);
                    fillSpaces(mNorthWestPieces);
                    break;
                case SOUTHEAST:
                    findSpaces(SOUTHEAST);
                    fillSpaces(mSouthEastPieces);
                    break;
                case SOUTHWEST:
                    findSpaces(SOUTHWEST);
                    fillSpaces(mSouthWestPieces);
                    break;
                case KING:
                    findSpacesKING(piece);
                    fillSpaces(mKingPieces);
                    break;
                case KNIGHT:
                    findSpaces(KNIGHT);
                    fillSpaces(mKnightPieces);
                    break;
                case NONE:
                default:
                    break;
            }
        }
    }

    private void findSpacesKING(Allocatable piece) {

        int currentRow = piece.getRow();
        int currentColumn = piece.getColumn();

        //validate upper row
        try{
            ArrayList<Allocatable> upperRow = mBoard.getBoard().get(currentRow - 1);

            upperRow.get(currentColumn).fillSpace();
            upperRow.get(currentColumn + 1).fillSpace();
            upperRow.get(currentColumn - 1).fillSpace();
        }catch (IndexOutOfBoundsException e ){
            //no upper row
        }

        //validate lower row
        try{
            ArrayList<Allocatable> lowerRow = mBoard.getBoard().get(currentRow + 1);

            lowerRow.get(currentColumn).fillSpace();
            lowerRow.get(currentColumn + 1).fillSpace();
            lowerRow.get(currentColumn - 1).fillSpace();
        }catch (IndexOutOfBoundsException e ){
            //no upper row
        }

        try{
            ArrayList<Allocatable> currentRowList = mBoard.getBoard().get(currentRow);

            currentRowList.get(currentColumn + 1).fillSpace();
            currentRowList.get(currentColumn - 1).fillSpace();
        }catch (IndexOutOfBoundsException e ){
            //no upper row
        }


        //mKingPieces


    }

    private void fillSpaces(ArrayList<Allocatable> pieces) {
        for (Allocatable piece :
                pieces) {
            piece.fillSpace();
        }
    }

    private void findSpaces(Allocatable.PieceRule rule) {
        //get the
    }


}
