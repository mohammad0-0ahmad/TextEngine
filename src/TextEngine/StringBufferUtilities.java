package TextEngine;

public interface StringBufferUtilities {
    /**
     *
     * @param x
     * @param y
     * @return
     */
    default boolean isXBeforeY(String x, String y){return false;}

    /**
     *
     * @param text
     * @param wordOrder
     * @return
     */
    default public StringBuffer getWord(StringBuffer text,long wordOrder){return null;}

    /**
     *
     * @param text
     * @param firstWordOrder
     * @param secondOrderWord
     * @return
     */
    default public StringBuffer switchWordsOrder(StringBuffer text,long firstWordOrder,long secondOrderWord){return null;}

    /**
     *
     * @param text
     * @return
     */
    default public long countAmountWords(StringBuffer text){return -1;}

    /**
     *
     * @param text
     * @return
     */
    default public  boolean isSorted(StringBuffer text) {return false;}

    /**
     *
     * @param text
     * @return
     */
    default public StringBuffer removeSigns(StringBuffer text){return null;}

}
