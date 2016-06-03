package br.com.gabrielmolter.chesschallenge.board;

import java.util.ArrayList;

/**
 * Created by Gabriel Molter on 31/05/2016 at 23:23 BRT.
 */
public class PieceBoardAllocator {

    private final ArrayList<ArrayList<Allocatable>> mBoardMatrix;
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
        mBoardMatrix = mBoard.getBoard();
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
                    fillSpaces(mSouthPieces);
                    break;
                case EAST:
                    fillSpaces(mEastPieces);
                    break;
                case WEST:
                    fillSpaces(mWeastPieces);
                    break;
                case NORTHEAST:
                    fillSpaces(mNorthEastPieces);
                    break;
                case NORTHWEST:
                    fillSpaces(mNorthWestPieces);
                    break;
                case SOUTHEAST:
                    fillSpaces(mSouthEastPieces);
                    break;
                case SOUTHWEST:
                    fillSpaces(mSouthWestPieces);
                    break;
                case KING:
                    fillSpacesKing(piece);
                    break;
                case KNIGHT:
                    fillSpacesKnight(piece);
                    break;
                case NONE:
                default:
                    break;
            }
        }
    }

    private void fillSpacesKnight(Allocatable piece) {

        int currentRow = piece.getRow();
        int currentColumn = piece.getColumn();

        fillIfExists(currentRow - 2, currentColumn + 1);
        fillIfExists(currentRow - 2, currentColumn - 1);

        fillIfExists(currentRow - 1, currentColumn + 2);
        fillIfExists(currentRow - 1, currentColumn - 2);

        fillIfExists(currentRow + 1, currentColumn + 2);
        fillIfExists(currentRow + 1, currentColumn - 2);

        fillIfExists(currentRow + 2, currentColumn + 1);
        fillIfExists(currentRow + 2, currentColumn - 1);

    }


    private void fillSpacesKing(Allocatable piece) {

        int currentRow = piece.getRow();
        int currentColumn = piece.getColumn();


        //validate upper row
        fillIfExists(currentRow - 1, currentColumn);
        fillIfExists(currentRow - 1, currentColumn - 1);
        fillIfExists(currentRow - 1, currentColumn +1);

        fillIfExists(currentRow + 1, currentColumn);
        fillIfExists(currentRow + 1, currentColumn - 1);
        fillIfExists(currentRow + 1, currentColumn +1);

        fillIfExists(currentRow, currentColumn -1);
        fillIfExists(currentRow , currentColumn +1);


    }

    private void fillIfExists(int row, int column) {
        try{
            mBoardMatrix.get(row).get(column).fillSpace();

        }catch (IndexOutOfBoundsException e){

        }

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
