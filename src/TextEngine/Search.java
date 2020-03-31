package TextEngine;

import java.util.ArrayList;

public interface Search extends Utilities {
    /**
     *
     * @param word
     * @param arrayUsedInSearch
     * @return
     */
    default int binary(String word, ArrayList<String> arrayUsedInSearch){

        int first = 0;
        int last = arrayUsedInSearch.size()-1;
        int middle = (first + last)/2;

        while (last >= first){
            //Checks the word we are looking for in the arrayList
            if (arrayUsedInSearch.get(middle).equals(word)){
                //Checks from the middle to the last word in the arrayList
                for (int i = middle; i <= last;i++){
                    if(!arrayUsedInSearch.get(i).equals(word)){
                        last = --i;
                        break;
                    }
                }
                //Checks from the middle to the first word in the arrayList
                for (int i = middle; i >= first; i--){
                    if (!arrayUsedInSearch.get(i).equals(word)){
                        first = ++i;
                        break;
                    }
                }
                return (last - first) + 1;
            }if (isXBeforeY(word,arrayUsedInSearch.get(middle))){
                last = middle-1;
            }else {
                first = middle+1;
            }
            middle = (last + first)/2;
        }
        return 0;
    }

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
