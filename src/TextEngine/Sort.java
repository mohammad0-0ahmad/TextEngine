package TextEngine;

import java.util.ArrayList;

public interface Sort extends Utilities {
    /**
     * Sorts the words within the array in alphabetical order
     * @param text the ArrayList of words that will be ordered
     * @return the value of the ArrayList once it has been ordered
     */
    default ArrayList<String> sorting(ArrayList<String> text){
        String temp;
        int n = text.size();
        for (int j = 0; j < n - 1; j++){
            for (int i = j + 1; i < n; i++) {
                    if(!isXBeforeY(text.get(j), text.get(i))){
                    temp = text.get(j);
                    text.set(j, text.get(i));
                    text.set(i, temp);
                }
            }
        }
        System.out.println(text);
        return text;
    }    /**
     * It checks if an array list is alphabetically sorted.
     * @param arrayList the data list that will be checked.
     * @return true with sorted parameter and false with unsorted one.
     */
    default  boolean isSorted(ArrayList<String> arrayList) {
        // Assume that arrayList is already sorted until the method finds one word that should be before another.
        boolean result = true;
        for (int i=0;i<arrayList.size()-1;i++){
            if (!isXBeforeY(arrayList.get(i),arrayList.get(i+1))){
                return false;
            }
        }
        return true;
    }
}
