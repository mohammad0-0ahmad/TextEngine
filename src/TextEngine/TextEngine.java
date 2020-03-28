package TextEngine;

import java.util.ArrayList;

public class TextEngine {
    /* Class variable */
    /**
     *
     */
    private static TextEngine instance = new TextEngine();

    ////////////////////////////////////////////////////
    /*> Member variables <*/

    /**
     *
     */
    private ArrayList<TextFile> files;

    ////////////////////////////////////////////////////
    /*>> Constructor <<*/

    /**
     *
     */
    private TextEngine() {
    }

    ////////////////////////////////////////////////////
    /*>>> Static methods <<<*/

    /**
     *
     * @return
     */
    public static TextEngine getInstance() {
        return instance;
    }

    ////////////////////////////////////////////////////
    /*>>>> Member methods <<<<*/

    /**
     *
     */
    public void start(){
    }

    /**
     *
     */
    private void open(){}

    /**
     *
     */
    private void sort(){}

    /**
     *
     */
    private void search(){}

    /**
     *
     */
    private void printSearchMethod(){}

    /**
     *
     * @param result
     */
    private void printSearchResult(int[][] result){}

    /**
     *
     */
    private void printFilesContent(){}

}
