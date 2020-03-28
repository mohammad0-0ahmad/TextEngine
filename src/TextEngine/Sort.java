package TextEngine;
public interface Sort extends StringBufferUtilities{
    /**
     * Note change the name of the method depending on sort algorithm
     * @param text
     * @return
     */
    default StringBuffer sort(StringBuffer text){return null;}
}
