package TextEngine;

import java.util.ArrayList;

public interface Sort extends Utilities {
    /**
     * Method to take the last element as a 'pivot' and sets that pivot in its correct position
     * within the sorted array, while also putting the all the smaller elements to the left of the pivot
     * and all the larger to the right
     * @param text the ArrayList of words that will be ordered
     * @param low the lowest index in the array
     * @param high the highest index in the array
     * @return the value of 'i +1' is the spot on the array that the pivot
     */
    default int partitioning(ArrayList<String> text, int low, int high){
        String temp;
        String pivot = text.get(text.size() - 1); // Getting the last string in the array
        int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (isXBeforeY(text.get(j), pivot)) {
                    i++;
                    temp = text.get(i);
                    text.set(i, text.get(j));
                    text.set(j, temp);
                }
            }
            temp = text.get(i + 1);
            text.set(i + 1, text.get(high));
            text.set(high, temp);
        return i + 1;
    }

    /**
     * Calls the partitioning-method as long as the the value of low is less than high
     * @param text the ArrayList of words that will be ordered
     * @param low the lowest index in the array
     * @param high the highest index in the array
     * @return the sorted text
     */
    default ArrayList<String> sort(ArrayList<String> text, int low, int high) {
        if (low < high){
            int pi = partitioning(text, low, high);
            System.out.println(pi);
            sort(text, low, pi-1);
            sort(text, pi+1, high);
        }
        return text;
    }
    /**
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
