package br.com.gabrielmolter.chesschallenge.board;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by Gabriel Molter on 31/05/2016 at 01:21 BRT.
 * Interface designed to store the default board space
 */
public interface Allocatable {

    public enum PieceRule{
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
    public boolean isEmpty();
    public void fillSpace();

    public EnumSet<PieceRule> getRules();

    public String getDisplayType();

    public int getRow();
    public int getColumn();
    public void setPosition(int row, int column);
}

