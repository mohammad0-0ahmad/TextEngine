package TextEngine;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TextFile implements Utilities,Sort,Search{
    /*> Member variables <*/

    /**
     *
     */
    private boolean sorted;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private ArrayList <String> content;

    ////////////////////////////////////////////////////
    /*>>Constructors <<*/

    /**
     * Constructor that uses to create a TextFile object by passing a text.
     * It uses for example when opening a text file.
     * @param name is the name of the text file
     * @param content the text that will be divided in words and saved inside content member variable.
     */
    public TextFile(String name, StringBuffer content) {
        this.name = name;
        this.content = new ArrayList<>();
        // Dividing content into words which will be saved inside content member variable.
        while (content.length()!=0){
            String[] temp = getFirstWord(content);
            content.replace(0, content.length(),temp[1]);
            if(!temp[0].equals("")){
                this.content.add(temp[0]);
            }
        }
        // Checking if the text is already sorted.
        this.sorted = isSorted(this.content);
    }

    ////////////////////////////////////////////////////
    /*>>> Static methods <<<*/

    /**
     * Opens a text file.
     * @param filePath the path of the desired file.
     * @return TextFile object or null if the process failed because of wrong input such as wrong file format or if the file is not exist.
     */
    public static TextFile open(String filePath){
        File file = new File(filePath);
        if (!file.exists()) {                                                                            // checks if the file is exist.
            return null;
        } else if (!file.getName().substring(file.getName().length() - 4).equals(".txt")) {              // checks file format.
            return null;
        }
        StringBuffer content = new StringBuffer();
        try {
            content.append(new String(Files.readAllBytes(Paths.get(filePath))));                             // read the file and store the content inside content variable.
        }catch (Exception e){
            return null;
        }
        return new TextFile(file.getName(),content);
    }

    /**
     *
     * @param content
     * @param path
     * @return
     */
    public static boolean save(String content,String path){
        return false;
    }
    ////////////////////////////////////////////////////
    /*>>>> Member methods <<<<*/

    /**
     * Getter method that return the name of the file name.
     * @return value of name member variable.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method that return the status of the text file whether or not it stores a sorted content.
     * @return a boolean value that is TRUE if its content is sorted or FALSE if it is not sorted.
     */
    public boolean isSorted() {
        return sorted;
    }

    /**
     C:\Users\98davfur\Documents    *
     * @return
     */
    public String getContent() {
        return null;
    }

    /**
     * If the textFiles aren't sorted yet, call the 'RemoveSign
     *
     */
    public void startSorting() {
        int lowestIndex = 0;
        int highestIndex= content.size()-1;
        if (!this.sorted){
            for(int i= 0; i < content.size(); i++){
                content.set(i,removeSigns(this.content.get(i)));
            }
            this.content = quickSort(this.content, lowestIndex, highestIndex);
        }
        System.out.println(content);
    }

    /**
     * A method that will decide which searching algorithm will be used to looking for a specific word and returns a number as search result.
     * @param wordToLookFor a word that method will looking for inside content array list.
     * @return a number that refer to amount of words that is equals with the passed word.
     */
    public int search(String wordToLookFor) {
        if (this.sorted){
            return binary(wordToLookFor, this.content);
        }else return linear(wordToLookFor, this.content);
    }
}
