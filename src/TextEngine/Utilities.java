package TextEngine;
public interface Utilities {
    /**
     * Compare words to know which word in the arguments will take first place when ordering alphabetically. Ascii order is related in some cases.
     * @param x the first word that will be used in comparision.
     * @param y the second word that will be used in comparision.
     * @return flase if the y is before x "by alphabetic order" OR true if x if before or equals with y.
     */
    default boolean isXBeforeY(String x, String y){
        // To avoid incorrect result when having uppercase letter. " To ignore ascii order"
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
     * @param word
     * @return
     */
    default  String removeSigns(String word){return null;}

}
