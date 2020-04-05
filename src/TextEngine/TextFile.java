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
        filePath = filePath.replace("\\","\\\\");                                         // replaces "\" with "\\" to be able to open the file. tested just on windows.
        File file = new File(filePath);
        if (!file.exists()) {                                                                            // checks if the file is exist.
            return null;
        } else if (!file.getName().substring(file.getName().length() - 4).equals(".txt")) {              // checks file format.
            return null;
        }
        StringBuffer content = new StringBuffer();
        try {
            content.append(new String(Files.readAllBytes(Paths.get(filePath))));                             // reads the file and store the content inside content variable.
        }catch (Exception e){
            return null;
        }
        return new TextFile(file.getName(),content);
    }

    /**
     * It creates or replace an external text file.
     * @param content content will be written inside the created text file.
     * @param path file path there text file will be stored.
     * @return a string that contain a message that can be shown for user.
     */
    public static String save(String content, String path){
        path = path.replace("\\","\\\\");                                         // replaces "\" with "\\" to be able to save the file. tested just on windows.
        File file = new File(path);
        try {
            // Create the external file.
            file.createNewFile();
            // Create FileWriter object that helps to write the content inside the created file.
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        }catch (IOException e){
            // Returns error message.
            return e.getMessage();
        }
        return "Det gick bra med att spara "+ file.getName() +" filen.";
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
     * It formats text formed from content text array depending on text file status (sorted or not).
     * @return a string hold formatted content.
     */
    public String getContent() {
        StringBuffer content = new StringBuffer();
        if(!sorted){
            for (int i =0; i < this.content.size(); i++) {
                content.append(this.content.get(i));
                // To add whitespaces between words except after last word of content.
                if (i != this.content.size()-1){
                    content.append(" ");
                }
            }
        }else {
            for (int i =0; i < this.content.size(); i++) {
                content.append(this.content.get(i));
                // To add whitespaces between words except after last word of content and after every 10 words.
                if (i != this.content.size()-1 && (i+1)%10 !=0){
                    content.append(" ");
                }else
                // To add break line after every 10 words.
                if ((i+1)%10 ==0){
                    content.append("\n");
                }
            }
        }
        return content.toString();
    }

    /**
     * If the textFiles aren't sorted yet, call the 'RemoveSign'-method which removes special-signs at the end of the word.
     * Then it calls the quickSortFunction which sorts the words in a alphabetical order
     *
     */
    public void sortContent() {
        int lowestIndex = 0;
        int highestIndex= content.size()-1;
        if (!this.sorted){
            for(int i= 0; i < content.size(); i++){
                content.set(i,removeSigns(this.content.get(i)));
            }
            this.content = quickSort(this.content, lowestIndex, highestIndex);
            sorted=true;
        }
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
