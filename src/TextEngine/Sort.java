package TextEngine;

import java.util.ArrayList;

public interface Sort {
    /**
     *
     * @param x
     * @param y
     * @return
     */
    default boolean isXBeforeY(String x, String y){return false;}

    /**
     * Note change the name of the method depending on sort algorithm
     * @param words
     * @return
     */
    default ArrayList<Word> sort(ArrayList<Word> words){return null;}
}
