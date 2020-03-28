package TextEngine;

import java.util.ArrayList;

public class TextFile {
    /*> Member variables <*/

    /**
     *
     */
    private boolean sorted;
    private String name;
    private ArrayList<Word> words;

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
     *
     */
    public static TextFile open(String filePath){
        return new TextFile("",null);
    }
    ////////////////////////////////////////////////////
    /*>>>> Member methods <<<<*/

    /**
     *
     */
    public String getName(){
        return null;
    }

    /**
     *
     */
    public void showWords(){ }

    /**
     *
     */
    private void isSorted(){}

    /**
     *
     */
    private void sort(){}

    /**
     *
     */
    private int search(String wordToLookFor){
        return 0;
    }

    /**
     *
     * @return
     */
    private ArrayList<Word> contentSplitter(){return null;}

}
