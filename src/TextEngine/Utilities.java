package TextEngine;

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

    /**
     * @param word
     * @return
     */
    default String removeSigns(String word) {
        return null;
    }

    /**
     * It used to get the first word if a text.
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
            if(firstWhiteSpaceIndex == -1){
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
