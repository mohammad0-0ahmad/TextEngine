package TextEngine;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TextFile implements Utilities,Sort{
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
        this.content = new ArrayList<String>();
        // Dividing content into words which will be saved inside content member variable.
        while (content.length()!=0){
            String[] temp = getFirstWord(content);
            content.replace(0, content.length(),temp[1]);
            if(temp[0] !=""){
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
     * @return TextFile object.
     * @throws IOException exception may occur during the process of the file opening.
     */
    public static TextFile open(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {                                                                            // checks if the file is exist.
            return null;
        } else if (!file.getName().substring(file.getName().length() - 4).equals(".txt")) {              // checks file format.
            return null;
        }
        StringBuffer content = new StringBuffer();
        content.append(new String(Files.readAllBytes(Paths.get(filePath))));                             // read the file and store the content inside content variable.
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
     *
     */
    public String getName() {
        return null;
    }

    /**
     *
     * @return
     */
    public String getContent() {
        return null;
    }

    /**
     *
     */
    public void sort() {
    }

    /**
     *
     */
    public int search(String wordToLookFor) {
        return 0;
    }
}
