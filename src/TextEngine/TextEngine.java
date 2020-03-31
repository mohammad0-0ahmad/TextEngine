package TextEngine;

import java.util.ArrayList;
import java.util.Scanner;

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
        this.files = new ArrayList<TextFile>();
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
     * It's a user interface in console that helps to select and execute a specific operation.
     */
    public void start(){
        System.out.println("\t\t>> Hej och välkommen till våra text motor.\u263A <<");
        Scanner userInput = new Scanner(System.in);
        String userSelection = "0";
        while (!userSelection.equals("e")) {
            System.out.println("" +
                    "\t(o) Öppna en ny fil." +
                    "\n\t(a) Skriva ut fil innehållet." +
                    "\n\t(b) Sortera de samtliga befintliga filerna." +
                    "\n\t(c) Leta efter ett ord." +
                    "\n\t(d) Spara aktuella resultat i en externa text fil." +
                    "\n\t(e) Avsluta Programmet."+
                    "\n\t\tInmata ditt val:");
            userSelection = userInput.nextLine();
            switch (userSelection){
                // To open a text file and add it to files member variable.
                case "o": open();break;
                // To print the contents of the exist text files.
                case "a": printFilesContent();break;
                //  To sort the content of all opened text files.
                case "b": sort();break;
                // To call the method that make a search inside all opened text files.
                case "c": search();break;
                // To save the current result of the opened text files.
                case "d":save();break;
                // To exit the application.
                case "e":
                    System.out.println("Hejdå och välkommen åter!! \uD83D\uDC4B");break;
                    // Printing an error message when user enter false options that is not exist in the main menu.
                default:
                    System.err.println("!!Ogiltigt val!! Välja gärna en giltig alternativ av lisatn nedan. \uD83D\uDE20");
            }
        }
    }

    /**
     * It's like a wizard that helps the user with opening a text file and add it to {@link #files} member variable..
     */
    private void open(){
        System.out.println("Ange filväg som tillhör till den önskad textfilen du vill öppna:");
        TextFile temp = TextFile.open(new Scanner(System.in).nextLine());
            if (temp != null){
                files.add(temp);
                System.out.println("Det gick bra med att öppna och addera filen. \u263A");
            }else {
                System.err.println("!!Det gick tyvärr inte att öppna filen. \u2639!! \nSe till att filensformat är '.txt' och att filen finns redan.");
            }
    }

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
     * @param result
     */
    private void printSearchResult(int[][] result){}

    /**
     *
     */
    private void printFilesContent(){}

    /**
     *
     */
    private void save(){}

}
