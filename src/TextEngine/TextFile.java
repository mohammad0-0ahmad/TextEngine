package TextEngine;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TextFile {
    /*> Member variables <*/

    /**
     *
     */
    private boolean sorted;
    private String name;
    private StringBuffer content;

    ////////////////////////////////////////////////////
    /*>>Constructors <<*/

    /**
     *
     */
    public TextFile(String name, StringBuffer content) {

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
     */
    public void getContent() {
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

    /**
     *
     * @param wordOrder
     */
    public void getWord(long wordOrder){}

    /**
     *
     * @param firstWordOrder
     * @param secondOrderWord
     */
    public void switchWordsOrder(long firstWordOrder,long secondOrderWord){}

    /**
     *
     * @return
     */
    public long countAmountWords(){return -1;}

    /**
     *
     */
    private void isSorted() {}

    /**
     *
     */
    private void removeSigns(){}


}
