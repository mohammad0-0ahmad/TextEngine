package TextEngine;

import java.util.ArrayList;

public interface Search {
    /**
     * Note change the name of the method depending on search algorithm
     * @param word
     * @param words
     * @return
     */
    default int search(String word, ArrayList<Word> words){return 0;}
}
