package TextEngine;

import java.lang.reflect.Array;

public interface Utilities {
    // The following variables represent its names with another word (" ","\t","\n") and holds the ascii values that are related to them.
    int WHITE_SPACE = 32;
    int BREAK_LINE = 10;
    int TAB = 9;


    /**
     * Compare words to know which word in the arguments will take first place when ordering alphabetically. Ascii order is related in some cases.
     *
     * @param x the first word that will be used in comparision.
     * @param y the second word that will be used in comparision.
     * @return flase if the y is before x "by alphabetic order" OR true if x if before or equals with y.
     */
    default boolean isXBeforeY(String x, String y) {
        // To avoid incorrect result when having uppercase letter. " To ignore ascii order"
        x = x.toLowerCase();
        y = y.toLowerCase();
        // if the x is before or x = y.
        if (x.compareTo(y) <= 0) {
            return true;
        }
        return false;
    }

    // !!Following method may don't cover all punctuation!!
    /** It removes some common punctuation that can be exist at the start or at the end of a word.
     * @param word word that need to be clean.
     * @return word without some common punctuation that can be exist on the edges.
     */
    default String removeSigns(String word) {
        StringBuffer result = new StringBuffer(word);
        // an array that hold ascii values for common punctuation. note 39 represent single quote mark.
        int[] commonPunctuationToRemove = new int[]{(int) '.', (int) ',', (int) '!', (int) '?', (int) '"', (int) ':', (int) '-', (int) '_', (int) '(', (int) ')', (int) '[', (int) ']', (int) '{', (int) '}', (int) '/', (int) '*', (int) '&', (int) '+', 39};
        // Cleaning the right side of the word.
        for (int i = 0; i < commonPunctuationToRemove.length; i++) {
            if (result.length() == 0) {
                break;
            }
            if ((int) result.charAt(result.length() - 1) == commonPunctuationToRemove[i]) {
                result.deleteCharAt(result.length() - 1);
                i = -1;
                continue;
            }
        }
        // Cleaning the left side of the word.
        for (int i = 0; i < commonPunctuationToRemove.length; i++) {
            if (result.length() == 0) {
                break;
            }
            if ((int) result.charAt(0) == commonPunctuationToRemove[i]) {
                result.deleteCharAt(0);
                i = -1;
                continue;
            }
        }

        return result.toString();
    }

    /**
     * It used to get the first word if a text.
     *
     * @param text is a String buffer that have text.
     * @return a string array that have first word at first place and rest in the second place OR empty String if text parameter is equals to null or if it is empty.
     */
    default String[] getFirstWord(StringBuffer text) {
        String[] toReturn = new String[2];
        int firstWhiteSpaceIndex = 0;
        while (firstWhiteSpaceIndex == 0) {
            // Get index of first whitespace.
            firstWhiteSpaceIndex = text.indexOf(" ");
            // -1 means that there is not a whitespace at all.
            if (firstWhiteSpaceIndex == -1) {
                // In this case firstWhiteSpaceIndex the index of last letter of the text
                firstWhiteSpaceIndex = text.length();
            }
            // In this case first word will be token and removed of the text.
            if (firstWhiteSpaceIndex > 0) {
                toReturn[0] = text.substring(0, firstWhiteSpaceIndex);
                toReturn[1] = text.substring(firstWhiteSpaceIndex);
            } else if (text.length() == 0) {
                // will return empty strings if the text is empty.
                return new String[]{"", ""};
            } else {
                // here deletes first white space.
                text.delete(0, 1);
            }
        }
        return toReturn;
    }
}
