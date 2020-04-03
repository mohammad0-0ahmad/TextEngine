package TextEngine;

import java.lang.reflect.Array;

public interface Utilities {
    // The following variables represent its names with another word (" ","\t","\n") and holds the ascii values that are related to them.
    int BREAK_LINE = 10;
    int TAB = 9;

    /**
     * Compare words to know which word in the arguments will take first place when ordering alphabetically. Ascii order is related in some cases.
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
    /** It removes some common punctuation that can exist at the start or end of a word.
     * @param word word that need to be clean.
     * @return word without some common punctuation that can be exist on the edges.
     */
    default String removeSigns(String word) {
        StringBuffer result = new StringBuffer(word);
        // an array that hold ascii values for common punctuation. note 39 represent single quote mark.
        int[] commonPunctuationToRemove = new int[]{(int) '.', (int) ',', (int) '!', (int) '?', (int) '"', (int) ':', (int) '-', (int) '_', (int) '(', (int) ')', (int) '[', (int) ']', (int) '{', (int) '}', (int) '/', (int) '*', (int) '&', (int) '+',BREAK_LINE,TAB,39};
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
     * @return a string array that have first word at first place and rest in the second place OR empty Strings if text parameter is equals to null or if it is empty.
     */
    default String[] getFirstWord(StringBuffer text) {
        text.replace(0,text.length(),text.toString().replaceAll("\r\n","\n"));
        // Array that will be returned.
        String[] toReturn = new String[2];
        // hold index that help with getting first word. ((The right edge of the word))
        int pointer = 0;
        // Get index of first whitespace.
        int firstWhiteSpaceIndex = text.indexOf(" ");
        // Get index of first breakLine.
        int firstBreakLineIndex = text.indexOf("\n");
        // Removing whitespaces or break lines that could be at first of the first word.
        while (firstWhiteSpaceIndex == 0 || firstBreakLineIndex == 0) {
            text.delete(0, 1);
            // Rearrange the index of first white space and break line.
            firstWhiteSpaceIndex = text.indexOf(" ");
            firstBreakLineIndex = text.indexOf("\n");
        }
        // In case first white space exists before first break line then pointer will hold index of at first white space else it will hold the index of first break line.
        if((firstWhiteSpaceIndex < firstBreakLineIndex && firstWhiteSpaceIndex!=-1) || (firstWhiteSpaceIndex > firstBreakLineIndex && firstBreakLineIndex==-1)){
            pointer = firstWhiteSpaceIndex;
        }else {
            pointer = firstBreakLineIndex;
        }
        // -1 means that there is not a whitespace or break line at all.
        // In this case pointer will hold the rest of the text.
        if (pointer == -1){
            pointer = text.length();
        }
            // In this case first word will be token and removed of the text.
            if (pointer > 0) {
                if(pointer != text.length() && text.charAt(pointer) == '\n'){
                    pointer++;
                }
                toReturn[0] = text.substring(0, pointer);
                toReturn[1] = text.substring(pointer);
            }else{
                // will return empty strings if the text is empty.
                return new String[]{"", ""};
            }
        return toReturn;
    }
}
