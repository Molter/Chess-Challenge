package br.com.gabrielmolter.chesschallenge.board;

import java.util.EnumSet;

/**
 * Created by Gabriel Molter on 31/05/2016 at 01:21 BRT.
 * Interface designed to store the default board space
 */
public interface Allocatable {

    Allocatable createCopy();

    enum PieceRule{
        NORTH,
        SOUTH,
        EAST,
        WEST,
        NORTHEAST,
        NORTHWEST,
        SOUTHEAST,
        SOUTHWEST,
        KING,
        KNIGHT,
        NONE
    }
    boolean isEmpty();
    void fillSpace();

    EnumSet<PieceRule> getRules();

    String getDisplayType();

    int getRow();
    int getColumn();
    void setPosition(int row, int column);
}

