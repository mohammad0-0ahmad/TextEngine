package TextEngine;

import java.util.ArrayList;

public interface Search extends Utilities {
    /**
     * Note change the name of the method depending on search algorithm
     * @param word
     * @param text
     * @return
     */
    default int search(String word, ArrayList<String> text){return 0;}
    /**
     *
     * @param word
     * @param text
     * @return
     */
    default int linear(String word,  ArrayList<String> text){return 0;}
}
