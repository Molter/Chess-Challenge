package br.com.gabrielmolter.chesschallenge.board;

import br.com.gabrielmolter.chesschallenge.Pieces.EmptySpace;
import br.com.gabrielmolter.chesschallenge.Pieces.InvalidAllocationException;

import java.util.List;

/**
 * Created by Gabriel Molter on 31/05/2016 at 23:23 BRT.
 */
public class PieceBoardAllocator {

    private final List<List<Allocatable>> mBoardMatrix;
    private Board mBoard;


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
     * @return Piece was allocated?
     */
    public boolean allocatePiece(int row, int column, Allocatable piece){
        if(!(mBoard.getPiece(row, column) instanceof EmptySpace) && !mBoard.getPiece(row, column).isEmpty() ){
            throw new InvalidAllocationException();
        }
        mBoard.setPiece(row, column, piece);

        boolean isValidAllocation = FlagAllInvalidSpaces(piece);
        return isValidAllocation;
    }


    /**
     * For each piece rule, invalidate the board positions that cannot be used
     * @param piece Allocatable piece
     */
    private boolean FlagAllInvalidSpaces(Allocatable piece) {
        boolean isValidAllocation;
        for (Allocatable.PieceRule rule: piece.getRules()){
            switch (rule){
                case NORTH:
                    isValidAllocation = fillSpacesNorth(piece);
                    break;
                case SOUTH:
                    isValidAllocation =   fillSpacesSouth(piece);
                    break;
                case EAST:
                    isValidAllocation =   fillSpacesEastPieces(piece);
                    break;
                case WEST:
                    isValidAllocation =   fillSpacesWestPieces(piece);
                    break;
                case NORTHEAST:
                    isValidAllocation =   fillSpacesNorthEastPieces(piece);
                    break;
                case NORTHWEST:
                    isValidAllocation =   fillSpacesNorthWestPieces(piece);
                    break;
                case SOUTHEAST:
                    isValidAllocation =   fillSpacesSouthEastPieces(piece);
                    break;
                case SOUTHWEST:
                    isValidAllocation =   fillSpacesSouthWestPieces(piece);
                    break;
                case KING:
                    isValidAllocation =    fillSpacesKing(piece);
                    break;
                case KNIGHT:
                    isValidAllocation =  fillSpacesKnight(piece);
                    break;
                case NONE:
                default:
                    isValidAllocation = true;
                    break;
            }
            if(!isValidAllocation){
                return false;
            }
        }
        return true;
    }

    /**
     * Fill all the spaces to the bottom-left of the piece
     * @param piece
     */
    private boolean fillSpacesSouthWestPieces(Allocatable piece) {
        int currentColumn = piece.getColumn();
        boolean isValidAllocation;

        for (int i = piece.getRow() - 1; i >= 0 ; i--) {
            isValidAllocation = fillIfExists(i, --currentColumn);
            if(!isValidAllocation){
                return false;
            }
        }
        return true;
    }

    /**
     * Fill all the spaces to the bottom-right of the piece
     * @param piece
     */
    private boolean fillSpacesSouthEastPieces(Allocatable piece) {
        int currentColumn = piece.getColumn();
        boolean isValidAllocation;

        for (int i = piece.getRow() - 1; i >= 0 ; i--) {
            isValidAllocation = fillIfExists(i, ++currentColumn);
            if(!isValidAllocation){
                return false;
            }
        }
        return true;
    }

    /**
     * Fill all the spaces to the up-left of the piece
     * @param piece
     */
    private boolean fillSpacesNorthWestPieces(Allocatable piece) {
        int currentColumn = piece.getColumn();
        boolean isValidAllocation;

        for (int i = piece.getRow() + 1; i < mBoardMatrix.size() ; i++) {
            isValidAllocation = fillIfExists(i, --currentColumn);
            if(!isValidAllocation){
                return false;
            }
        }
        return true;
    }

    /**
     * Fill all the spaces to the up-right of the piece
     * @param piece
     */
    private boolean fillSpacesNorthEastPieces(Allocatable piece) {
        int currentColumn = piece.getColumn();
        boolean isValidAllocation;

        for (int i = piece.getRow() + 1; i < mBoardMatrix.size() ; i++) {
            isValidAllocation = fillIfExists(i, ++currentColumn);
            if(!isValidAllocation){
                return false;
            }
        }
        return true;
    }

    /**
     * Fill all the spaces to the left of the piece
     * @param piece
     */
    private boolean fillSpacesWestPieces(Allocatable piece) {
        int currentRow = piece.getRow();
        boolean isValidAllocation;

        for (int i = piece.getColumn() - 1; i >= 0 ; i--) {
            isValidAllocation = fillIfExists(currentRow, i);
            if(!isValidAllocation){
                return false;
            }
        }
        return true;
    }

    /**
     * Fill all the spaces to the right of the piece
     * @param piece
     */
    private boolean fillSpacesEastPieces(Allocatable piece) {
        int currentRow = piece.getRow();
        boolean isValidAllocation;
        for (int i = piece.getColumn() + 1; i < mBoardMatrix.get(piece.getRow()).size() ; i++) {
            isValidAllocation = fillIfExists(currentRow, i);
            if(!isValidAllocation){
                return false;
            }
        }
        return true;
    }

    /**
     * Fill all the spaces below the piece
     * @param piece
     */
    private boolean fillSpacesSouth(Allocatable piece) {
        int currentColumn = piece.getColumn();
        boolean isValidAllocation;
        for (int i = piece.getRow() + 1; i < mBoardMatrix.size() ; i++) {
            isValidAllocation = fillIfExists(i, currentColumn);
            if(!isValidAllocation){
                return false;
            }
        }
        return true;
    }

    /**
     * * Fill all the spaces above the piece
     * @param piece
     */
    private boolean fillSpacesNorth(Allocatable piece) {
        int currentColumn = piece.getColumn();
        boolean isValidAllocation;
        for (int i = piece.getRow() - 1; i >= 0 ; i--) {
            isValidAllocation = fillIfExists(i, currentColumn);
            if(!isValidAllocation){
                return false;
            }
        }
        return true;
    }

    /**
     * Specific method for Knight
     * @param piece Knight piece
     */
    private boolean fillSpacesKnight(Allocatable piece) {

        int currentRow = piece.getRow();
        int currentColumn = piece.getColumn();
        boolean isValidAllocation;

        isValidAllocation = fillIfExists(currentRow - 2, currentColumn + 1);
        if(!isValidAllocation){
            return false;
        }
        fillIfExists(currentRow - 2, currentColumn - 1);
        if(!isValidAllocation){
            return false;
        }

        isValidAllocation = fillIfExists(currentRow - 1, currentColumn + 2);
        if(!isValidAllocation){
            return false;
        }
        isValidAllocation = fillIfExists(currentRow - 1, currentColumn - 2);
        if(!isValidAllocation){
            return false;
        }

        isValidAllocation = fillIfExists(currentRow + 1, currentColumn + 2);
        if(!isValidAllocation){
            return false;
        }
        isValidAllocation = fillIfExists(currentRow + 1, currentColumn - 2);
        if(!isValidAllocation){
            return false;
        }

        isValidAllocation = fillIfExists(currentRow + 2, currentColumn + 1);
        if(!isValidAllocation){
            return false;
        }
        isValidAllocation = fillIfExists(currentRow + 2, currentColumn - 1);
        return isValidAllocation;

    }

    /**
     * Specific method for King
     * @param piece King piece
     */
    private boolean fillSpacesKing(Allocatable piece) {

        int currentRow = piece.getRow();
        int currentColumn = piece.getColumn();

        boolean isValidAllocation;
        //validate upper row
        isValidAllocation = fillIfExists(currentRow - 1, currentColumn);
        if(!isValidAllocation){
            return false;
        }
        isValidAllocation = fillIfExists(currentRow - 1, currentColumn - 1);
        if(!isValidAllocation){
            return false;
        }
        isValidAllocation = fillIfExists(currentRow - 1, currentColumn +1);
        if(!isValidAllocation){
            return false;
        }
        isValidAllocation = fillIfExists(currentRow + 1, currentColumn);
        if(!isValidAllocation){
            return false;
        }
        isValidAllocation = fillIfExists(currentRow + 1, currentColumn - 1);
        if(!isValidAllocation){
            return false;
        }
        isValidAllocation = fillIfExists(currentRow + 1, currentColumn +1);
        if(!isValidAllocation){
            return false;
        }
        isValidAllocation = fillIfExists(currentRow, currentColumn -1);
        if(!isValidAllocation){
            return false;
        }
        isValidAllocation = fillIfExists(currentRow , currentColumn +1);
        return isValidAllocation;

    }



    /**
     * Fill the space if possible.
     * @param row
     * @param column
     * @return Space was filled
     */
    private boolean fillIfExists(int row, int column) {

        try{
            if(row > mBoardMatrix.size() || row < 0){
                return true;
            }
            if(column >  mBoardMatrix.get(row).size() || column < 0){
                return true;
            }

            if(mBoardMatrix.get(row).get(column).isEmpty() ||  mBoardMatrix.get(row).get(column) instanceof  EmptySpace){
                mBoardMatrix.get(row).get(column).fillSpace();
                return true;
            }

            return false;

        }catch (IndexOutOfBoundsException e){
            //invalid cell, nothing to do right now.
            return true;
        }

    }
}
