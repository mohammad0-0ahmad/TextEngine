package TextEngine;

import java.util.ArrayList;

public interface Sort extends Utilities {
    /**
     * Note change the name of the method depending on sort algorithm
     * @param text
     * @return
     */
    default StringBuffer sort(StringBuffer text){return null;}
    /**
     *
     * @param arrayList
     * @return
     */
    default  boolean isSorted(ArrayList<String> arrayList) {return false;}
}
