package TextEngine;
public interface Sort {
    /**
     *
     * @param x
     * @param y
     * @return
     */
    default boolean isXBeforeY(String x, String y){return false;}

    /**
     * Note change the name of the method depending on sort algorithm
     * @param text
     * @return
     */
    default StringBuffer sort(StringBuffer text){return null;}
}
