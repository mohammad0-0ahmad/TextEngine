package textEngine;

/**
 * It includes all method that are such as a utility.
 */
public interface Utilities {
    // The following variables represent its names with another word (" ","\t","\n") and holds the ascii values that are related to them.
    int BREAK_LINE = 10;
    int TAB = 9;

    /**
     * Compare words or numbers to know which one of the arguments will take first place (when ordering alphabetically in case the were words). Ascii order is related in some cases.
     * @param x the first word that will be used in comparision.
     * @param y the second word that will be used in comparision.
     * @return flase if the y is before x "by alphabetic order in case were x and y words" OR true if x if before or equals with y.
     */
    default boolean isXBeforeY(String x, String y) {
        // Trying convert strings to numbers and compare them.
        try {
            int xAsNumber = Integer.parseInt(x);
            int yAsNumber = Integer.parseInt(y);
            return xAsNumber <= yAsNumber;
        }catch (Exception ignored){}
        // To avoid incorrect result when having uppercase letter. " To ignore ascii order"
        try{
            x = x.toLowerCase();
            y = y.toLowerCase();
        }catch (Exception ignored){}
        // if the x is before or x = y.
        return (x.compareTo(y) <= 0);
    }

    // !!Following method may don't cover all punctuation!!
    /** It removes some common punctuation or other symbols that can exist at the start or end of a word except "-" at left side that can refer to negative numbers.
     * @param word word that need to be clean.
     * @return word without some common punctuation that can be exist on the edges.
     */
    default String removeSigns(String word) {
        // Returning empty string in case word was empty.
        if(word.length()==0){return "";}
        // A string will be returned later.
        StringBuffer result = new StringBuffer(word);
        // variables names explain the purpose.  couldBeNegativeNumber will be used to handle a string that is a negative number.
        boolean doneWithRightEdge = false, doneWithLeftSide = false ,couldBeNegativeNumber = false;
        // Start cleaning.
        while ((!doneWithLeftSide || !doneWithRightEdge) && result.length()>0 ){
            // Cleaning left edge.
            if (!doneWithLeftSide) {
                int firstLetterAscii = result.charAt(0);
                // Check this link to understand what the followings numbers (Ascii values) means. http://www.asciitable.com/
                // OBS! In the previous link the range between 128 and 165 doesn't work correctly with swedish letters. So this range is replaced with following values.
                // 229 å , 197 Å , 228 ä , 196 Ä , 214 Ö , 246 ö
                if (( (firstLetterAscii >= 48 && firstLetterAscii <= 57) || (firstLetterAscii >= 65 && firstLetterAscii <= 90) || (firstLetterAscii >= 97 && firstLetterAscii <= 122) ) || firstLetterAscii == 229  || firstLetterAscii==197 || firstLetterAscii==228 || firstLetterAscii==196 || firstLetterAscii==214 || firstLetterAscii==246) {
                    doneWithLeftSide = true;
                } else {
                    // setting couldBeNegativeNumber as true in case the first letter is "-" and the next letter is a number.
                    couldBeNegativeNumber = result.length() > 1 && firstLetterAscii == 45 && result.charAt(1) >= 48 && result.charAt(1) <= 57;
                    // Removing first char.
                    result.deleteCharAt(0);
                }
            }
            if(result.length()==0){break;}
            // Cleaning right edge.
            if (!doneWithRightEdge) {
                int lastLetterAscii = result.charAt(result.length()-1);
                if (( (lastLetterAscii >= 48 && lastLetterAscii <= 57) || (lastLetterAscii >= 65 && lastLetterAscii <= 90) || (lastLetterAscii >= 97 && lastLetterAscii <= 122) || (lastLetterAscii >= 128 && lastLetterAscii <= 165) )  || lastLetterAscii == 229  || lastLetterAscii==197 || lastLetterAscii==228 || lastLetterAscii==196 || lastLetterAscii==214 || lastLetterAscii==246) {
                    doneWithRightEdge = true;
                } else {
                    // Removing last letter.
                    result.deleteCharAt(result.length()-1);
                }
            }
        }
        // Adding a "-" in case the last removed letter was "-" to be able to keep negative numbers.
        if (couldBeNegativeNumber){
            return "-" + result.toString();
        }
        return result.toString();
    }

    /**
     * It used to get the first word if a text.
     *
     * @param text is a String buffer that store a text.
     * @return a string array that store first word at first place and rest in the second place OR empty Strings if text parameter is equals to null or if it is empty.
     */
    default String[] getFirstWord(StringBuffer text) {
        text.replace(0,text.length(),text.toString().replaceAll("\r\n","\n"));
        // Array that will be returned.
        String[] toReturn = new String[2];
        // hold index that help with getting first word. ((The right edge of the word))
        int pointer;
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