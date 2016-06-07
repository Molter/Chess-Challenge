package br.com.gabrielmolter.chesschallenge.board;

import br.com.gabrielmolter.chesschallenge.Pieces.InvalidAllocationException;

import java.util.ArrayList;

/**
 * Created by Gabriel Molter on 31/05/2016 at 23:23 BRT.
 */
public class PieceBoardAllocator {

    private final ArrayList<ArrayList<Allocatable>> mBoardMatrix;
    private Board mBoard;


    private ArrayList<Allocatable> mNorthEastPieces = new ArrayList<>();
    private ArrayList<Allocatable> mNorthWestPieces = new ArrayList<>();
    private ArrayList<Allocatable> mEastPieces = new ArrayList<>();
    private ArrayList<Allocatable> mWeastPieces = new ArrayList<>();
    private ArrayList<Allocatable> mSouthPieces = new ArrayList<>();
    private ArrayList<Allocatable> mSouthEastPieces = new ArrayList<>();
    private ArrayList<Allocatable> mSouthWestPieces = new ArrayList<>();

    /**
     * Constructor
     * @param board Parent Board
     */
    public PieceBoardAllocator (Board board){

        mBoard = board;
        mBoardMatrix = mBoard.getBoard();
    }

    /**
     * Allocate a piece on the board and invalidate the respective positions
     * @param row Row index
     * @param column Columnn Index
     * @param piece Allocatable piece
     */
    public void allocatePiece(int row, int column, Allocatable piece){
        if(!mBoard.getPiece(row, column).isEmpty()){
            throw new InvalidAllocationException();
        }

        mBoard.setPiece(row, column, piece);
        FlagAllInvalidSpaces(piece);
    }


    /**
     * For each piece rule, invalidate the board positions that cannot be used
     * @param piece Allocatable piece
     */
    private void FlagAllInvalidSpaces(Allocatable piece) {
        for (Allocatable.PieceRule rule: piece.getRules()){
            switch (rule){
                case NORTH:
                    fillSpacesNorth(piece);
                    break;
                case SOUTH:
                    fillSpacesSouth(piece);
                    break;
                case EAST:
                    fillSpacesEastPieces(piece);
                    break;
                case WEST:
                    fillSpacesWestPieces(piece);
                    break;
                case NORTHEAST:
                    fillSpacesNorthEastPieces(piece);
                    break;
                case NORTHWEST:
                    fillSpacesNorthWestPieces(piece);
                    break;
                case SOUTHEAST:
                    fillSpacesSouthEastPieces(piece);
                    break;
                case SOUTHWEST:
                    fillSpacesSouthWestPieces(piece);
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

    /**
     * Fill all the spaces to the bottom-left of the piece
     * @param piece
     */
    private void fillSpacesSouthWestPieces(Allocatable piece) {
        int currentColumn = piece.getColumn();

        for (int i = piece.getRow() - 1; i >= 0 ; i--) {
            fillIfExists(i, --currentColumn);
        }
    }

    /**
     * Fill all the spaces to the bottom-right of the piece
     * @param piece
     */
    private void fillSpacesSouthEastPieces(Allocatable piece) {
        int currentColumn = piece.getColumn();

        for (int i = piece.getRow() - 1; i >= 0 ; i--) {
            fillIfExists(i, ++currentColumn);
        }
    }

    /**
     * Fill all the spaces to the up-left of the piece
     * @param piece
     */
    private void fillSpacesNorthWestPieces(Allocatable piece) {
        int currentColumn = piece.getColumn();

        for (int i = piece.getRow() + 1; i < mBoardMatrix.size() ; i++) {
            fillIfExists(i, --currentColumn);
        }
    }

    /**
     * Fill all the spaces to the up-right of the piece
     * @param piece
     */
    private void fillSpacesNorthEastPieces(Allocatable piece) {
        int currentColumn = piece.getColumn();

        for (int i = piece.getRow() + 1; i < mBoardMatrix.size() ; i++) {
            fillIfExists(i, ++currentColumn);
        }
    }

    /**
     * Fill all the spaces to the left of the piece
     * @param piece
     */
    private void fillSpacesWestPieces(Allocatable piece) {
        int currentRow = piece.getRow();

        for (int i = piece.getColumn() - 1; i >= 0 ; i--) {
            fillIfExists(currentRow, i);
        }
    }

    /**
     * Fill all the spaces to the right of the piece
     * @param piece
     */
    private void fillSpacesEastPieces(Allocatable piece) {
        int currentRow = piece.getRow();

        for (int i = piece.getColumn() + 1; i < mBoardMatrix.get(piece.getRow()).size() ; i++) {
            fillIfExists(currentRow, i);
        }
    }

    /**
     * Fill all the spaces below the piece
     * @param piece
     */
    private void fillSpacesSouth(Allocatable piece) {
        int currentColumn = piece.getColumn();

        for (int i = piece.getRow() + 1; i < mBoardMatrix.size() ; i++) {
            fillIfExists(i, currentColumn);
        }
    }

    /**
     * * Fill all the spaces above the piece
     * @param piece
     */
    private void fillSpacesNorth(Allocatable piece) {
        int currentColumn = piece.getColumn();

        for (int i = piece.getRow() - 1; i >= 0 ; i--) {
            fillIfExists(i, currentColumn);
        }
    }

    /**
     * Specific method for Knight
     * @param piece Knight piece
     */
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

    /**
     * Specific method for King
     * @param piece King piece
     */
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

    /**
     * Fill the space if possible.
     * @param row
     * @param column
     */
    private void fillIfExists(int row, int column) {

        try{

            if(row > mBoardMatrix.size() || row < 0){
                return;
            }
            if(column >  mBoardMatrix.get(row).size() || column < 0){
                return;
            }

            mBoardMatrix.get(row).get(column).fillSpace();

        }catch (IndexOutOfBoundsException e){
            //invalid row, nothing to do right now.
        }

    }

    /**
     * Fill spaces array
     * @param pieces
     * @param piece
     */
    private void fillSpaces(ArrayList<Allocatable> pieces, Allocatable piece) {


        for (Allocatable cell :
                pieces) {
            cell.fillSpace();
        }
    }


}
