package TextEngine;

import java.util.ArrayList;
import java.util.Scanner;

public class TextEngine implements Sort {
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
    public void start() {
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
                    "\n\t(e) Avsluta Programmet." +
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
    private void open() {
        System.out.println("Ange filväg som tillhör till den önskad textfilen du vill öppna:");
        TextFile temp = TextFile.open(new Scanner(System.in).nextLine());
        if (temp != null) {
            files.add(temp);
            System.out.println("Det gick bra med att öppna och addera filen. \u263A");
        } else {
            System.err.println("!!Det gick tyvärr inte att öppna filen. \u2639!! \nSe till att filensformat är '.txt' och att filen finns redan.");
        }
    }

    /**
     *
     */
    private void sort() {
        if (files.size() > 0){
            for (int i = 0; i < files.size(); i++) {
                if (!files.get(i).isSorted()){
                    files.get(i).startSorting();
                }
            }
        }
    }

    /**
     * It's like a wizard that helps the user with looking for a word inside text files {@link #files} member variable..
     */
    private void search() {
        if (files.size() > 0) {
            boolean filesContentsIsSorted = true, userDecision = false;
            // Checking if every opened text file content is sorted be checking sorted member value.
            for (int i = 0; i < files.size(); i++) {
                if (!files.get(i).isSorted()) {
                    filesContentsIsSorted = false;
                    break;
                }
            }
            // Let the user decide whether or not want to execute the searching in case contents is not sorted.
            if (!filesContentsIsSorted) {
                System.out.println("Jag rekomenderar att exekvera sökning på sorterad text för att få noggrannt resultat så sortera gärna texter först!!");
                System.out.println("Annars Jag kan fortfarande exekvera en sökning.\n Vill du fortsätta ändå? \n (y) ja, det vill jag. \n (Annars) Visa huvudmenyn.");
                if (new Scanner(System.in).nextLine().equals("y")) {
                    userDecision = true;
                }
            }
            // Start searching.
            if (filesContentsIsSorted || userDecision) {
                System.out.println("Inmata gärna ordet du vill leta efter:");
                // Word will be entered by user.
                String wordToLookFor = new Scanner(System.in).nextLine();
                // array that will hold the search result.
                int[][] searchResult = new int[files.size()][2];
                // Start searching file by file and save the result inside searchResult array.
                for (int i = 0; i < files.size(); i++) {
                    searchResult[i][0] = i;
                    searchResult[i][1] = files.get(i).search(wordToLookFor);
                }
                System.out.println("\t\tResultatet av sökning på " + wordToLookFor + "ordet:");
                // Calling the method that prints sorted result.
                System.out.println(sortSearchResult(searchResult));
            }
        }else {
            System.err.println("Du har inte öppnat någon textfil än!!");
        }
    }

    /**
     * It sort search result.
     * @param result a sorted search result.
     */
    private String sortSearchResult(int[][] result) {
        StringBuffer resultText = new StringBuffer("");
        // todo Sorting the result

        // Creating the text that show the result.
        for (int i = 0 ; i < result.length;i++){
            //
            String fileName = this.files.get(result[i][0]).getName();
            //
            if(result[i][1]>0) {
                resultText.append("Sökord finns " + result[i][1] + " gånger  i " + fileName + "  filen.");
            }else {break;}
        }
        return resultText.toString();
    }

    /**
     *
     */
    private void printFilesContent() {
    }

    /**
     *
     */
    private void save() {
    }

}
