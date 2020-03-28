package TextEngine;
public interface Search {
    /**
     * Note change the name of the method depending on search algorithm
     * @param word
     * @param text
     * @return
     */
    default int search(String word, StringBuffer text){return 0;}
}
