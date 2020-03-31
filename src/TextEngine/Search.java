package TextEngine;

import java.util.ArrayList;

public interface Search extends Utilities {
    /**
     * Note change the name of the method depending on search algorithm
     * @param word
     * @param text
     * @return
     */
    default int search(String word, ArrayList<String> text){return 0;}

    /**
     * It execute a linear searching on a arrayList.
     * @param word a word that method looks for.
     * @param arrayUsedInSearch an string array list that could store the word.
     * @return -2 if array list is null OR -1 if it is empty OR 0 if the word is not exist OR larger number that refer to amount of words that is equals with the passed word.
     */
    default int linear(String word,ArrayList<String> arrayUsedInSearch){
        // In case arrayUsedInSearch is null
        if (arrayUsedInSearch == null ){
            return -2;
        }else if(arrayUsedInSearch.size() == 0){ // In case arrayUsedInSearch is empty.
            return -1;
        }
        // start counting.
        int found = 0;
        for (int i = 0; i < arrayUsedInSearch.size();i++){
            if (arrayUsedInSearch.get(i).equals(word)){
                found++;
            }
        }
        return found;
    }
}
