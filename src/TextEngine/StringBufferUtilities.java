package TextEngine;

public interface StringBufferUtilities{
    // The following variables represent its names with another word (" ","\t","\n") and holds the ascii values that are related to them.
    int whiteSpace = 32;
    int breakLine = 10;
    int  tab = 9;
    /**
     * Compare words to know which word in the arguments will take first place when ordering alphabetically. Ascii order is related in some cases.
     * @param x the first word that will be used in comparision.
     * @param y the second word that will be used in comparision.
     * @return flase if the y is before x "by alphabetic order" OR true if x if before or equals with y.
     */
    default boolean isXBeforeY(String x, String y){
        // to avoid incorrect result when having uppercase letter. " To ignore ascii order"
        x = x.toLowerCase();
        y = y.toLowerCase();
        // if the x is before or x = y.
        if(x.compareTo(y) <=0){
            return true;
        }
        return false;
    }

    /**
     *
     * @param text
     * @param wordOrder
     * @return
     */
    default StringBuffer getWord(StringBuffer text,long wordOrder){return null;}

    /**
     *
     * @param text
     * @param firstWordOrder
     * @param secondOrderWord
     * @return
     */
    default StringBuffer switchWordsOrder(StringBuffer text,long firstWordOrder,long secondOrderWord){return null;}

    /**
     *Counts amount of words that exist in a text.
     * @param text the text that hold the words that will be counted.
     * @return words amount.
     */
    default int countWordsAmount(StringBuffer text){
        int wordsAmount = 0;
        int lettersAmount = text.length();
        boolean canCounts = false;
        //The following for loop will check letter by letter to count the words depending on letter.
        for (int i=0;i<lettersAmount;i++){
            if ((int)text.charAt(i) != whiteSpace && (int)text.charAt(i) != breakLine  && (int)text.charAt(i) != tab && !canCounts){
                canCounts = true;
            }else if (((int)text.charAt(i) == whiteSpace || (int)text.charAt(i) == breakLine  || (int)text.charAt(i) == tab) && canCounts ){
                wordsAmount++;
                canCounts = false;
            }
            // The following if statement counts last word if it was accepted letter.(accepted letters should be not a whitespace,linebreak or multiple whitespaces "tab")
            if(i == lettersAmount-1 && canCounts){
                wordsAmount++;
            }
        }
        return wordsAmount;
    }

    /**
     *
     * @param text
     * @return
     */
    default  boolean isSorted(StringBuffer text) {return false;}

    /**
     *
     * @param text
     * @return
     */
    default  StringBuffer removeSigns(StringBuffer text){return null;}

}
