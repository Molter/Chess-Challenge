package br.com.gabrielmolter.chesschallenge.board;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel Molter on 07/06/2016 at 01:27 BRT.
 */
public class BoardAllocator {

    private int mRows;
    private int mColumns;
    private Board mEmptyBoard;

    private List<Board> mCompletedBoards = new ArrayList<>();

    /**
     * Contructor
     * @param rows
     * @param columns
     */
    public BoardAllocator(int rows, int columns) {
        mRows = rows;
        mColumns = columns;
        mEmptyBoard = new Board(rows, columns);
    }

    /**
     * Show all valid board configurations
     */
    public void displayCompletedBoards() {
        for (Board board :
                mCompletedBoards) {
            board.displayBoard();
        }
    }

    /**
     * If at least one result is found the configuratio is valid
     * @return
     */
    public boolean isConfigurationValid(){
        return mCompletedBoards.size() > 0;
    }

    /**
     * Allocate the places within the board
     * @param pieces
     */
    public void findAllocations(List<Allocatable> pieces){

    }
}
