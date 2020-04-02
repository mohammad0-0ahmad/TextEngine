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
        System.out.print("\t\t>> Hej och välkommen till våra text motor.\u263A <<");
        Scanner userInput = new Scanner(System.in);
        String userSelection = "0";
        while (!userSelection.equals("e")) {
            System.out.println("" +
                    "\n\t(o) Öppna en ny fil och addera innehållet." +
                    "\n\t(a) Skriva ut innehållet på alla öppnades filer." +
                    "\n\t(b) Sortera de samtliga befintliga filerna." +
                    "\n\t(c) Leta efter ett ord." +
                    "\n\t(d) Spara aktuella resultat i en externa text fil." +
                    "\n\t(e) Avsluta Programmet." +
                    "\n\t\tInmata ditt val:");
            userSelection = userInput.nextLine();
            switch (userSelection){
                // To open a text file and add it to files member variable.
                case "o": openFile();break;
                // To print the contents of the exist text files.
                case "a": System.out.println(getContents());break;
                //  To sort the content of all opened text files.
                case "b": sortFilesContents();break;
                // To call the method that make a search inside all opened text files.
                case "c": searchInFiles();break;
                // To save the current result of the opened text files.
                case "d":
                    saveFilesContents();break;
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
    private void openFile() {
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
    private void sortFilesContents() {
        if (files.size() > 0){
            for (int i = 0; i < files.size(); i++) {
                if (!files.get(i).isSorted()){
                    files.get(i).sortContent();
                }
            }
        }
    }

    /**
     * It's like a wizard that helps the user with looking for a word inside text files {@link #files} member variable..
     */
    private void searchInFiles() {
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
                    System.out.println("!! Notera att vissa tecken kan räknas som en bokstav av ordet i fall fanns inte mellanslag mellan dem.\n\t\tExemplvis: (. , : ! ? ) osv");
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
                System.out.println("\t\tResultatet av sökning på \" " + wordToLookFor + " \" ordet:");
                // Calling the method that prints sorted result.
                System.out.println(sortSearchResult(searchResult));
            }
        }else {
            System.err.println("Du har inte öppnat någon textfil än!!");
        }
    }

    /**
     * It sort search result and return a string that displays to the user.
     * @param result  unsorted search result.
     * @return a text that is readable by the user.
     */
    private String sortSearchResult(int[][] result) {
        StringBuffer resultText = new StringBuffer("");
        //Sorting the result
        result = insertion(result);
        // Creating the text that show the result.
        for (int i = result.length-1 ; i >= 0 ;i--){
            // Get file name that is related to search result.
            String fileName = this.files.get(result[i][0]).getName();
            // To skipping the result of the files that don't contain the word.
            if(result[i][1]>0) {
                resultText.append("Sökordet finns " + result[i][1] + " gånger i " + fileName + "  filen.");
            }else {break;}                  //no need to continue because the result array is sorted.
        }
        if(resultText.toString().equals("")){
            return "\t\t!!Ingen textfil innehåller sökordet!!";
        }
        return resultText.toString();
    }

    /**
     * It organizes the output of all opened files and prepare it to be readable by user.
     * @return a string that hold the contents of all opened text files that stores inside {@link #files}.
     */
    private String getContents() {
        // In case the user have not opened a text file yet.
        if (files.size() == 0) {
            return "Du har inte öppnat någon textfil än!!";
        } else {
            // Prepare the result that will be show to the user later.
            StringBuffer resultToPrint = new StringBuffer("");
            for (int i = 0; i < files.size(); i++) {
                resultToPrint.append("Filnamn: " + files.get(i).getName() + "\n>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<\n" + files.get(i).getContent() + "\n________________________________________\n");
            }
            return resultToPrint.toString();
        }
    }

    /**
     *
     */
    private void saveFilesContents() {
    }

}
