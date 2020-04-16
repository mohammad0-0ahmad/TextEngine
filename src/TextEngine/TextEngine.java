package TextEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * It represents an object that can handle text files.
 */
public class TextEngine implements Sort {
    /* Class variable */
    /**
     * The only instance of TextEngine object.
     */
    private final static TextEngine instance = new TextEngine();

    ////////////////////////////////////////////////////
    /*> Member variables <*/

    /**
     * Array list that hold all opened file during runtime.
     */
    private final ArrayList<TextFile> files;

    ////////////////////////////////////////////////////
    /*>> Constructor <<*/

    /**
     * The constructor of TextEngine class.
     */
    private TextEngine() {
        this.files = new ArrayList<>();
    }

    ////////////////////////////////////////////////////
    /*>>> Static methods <<<*/

    /**
     * It returns the TextEngine object.
     * @return The instance of TextEngine Type. "Singleton"
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
        System.out.print(USER_MESSAGE.GREETING);
        Scanner userInput = new Scanner(System.in);
        String userSelection = "0";
        while (!userSelection.equals("e")) {
            System.out.println(USER_MESSAGE.CONSOLE_MENU);
            userSelection = userInput.nextLine();
            switch (userSelection) {
                // To open a text file and add it to files member variable.
                case "o":
                    openFile();
                    break;
                // To print the contents of the exist text files.
                case "a":
                    System.out.println(getContents());
                    break;
                //  To sort the content of all opened text files.
                case "b":
                    sortFilesContents();
                    break;
                // To call the method that make a search inside all opened text files.
                case "c":
                    searchInFiles();
                    break;
                // To save the current result of the opened text files.
                case "d":
                    saveFilesContents();
                    break;
                // To exit the application.
                case "e":
                    System.out.println(USER_MESSAGE.GOOD_BYE);
                    break;
                // Printing an error message when user enter false options that is not exist in the main menu.
                default:
                    System.out.println(USER_MESSAGE.INVALID_SELECTION);
            }
        }
    }

    /**
     * It's like a wizard that helps the user with opening a text file and add it to {@link #files} member variable..
     */
    private void openFile() {
        System.out.println(USER_MESSAGE.ASKING_TO_ENTER_FILE_PATH );
        TextFile temp = TextFile.open(new Scanner(System.in).nextLine());
        if (temp != null) {
            files.add(temp);
            System.out.println(USER_MESSAGE.FILE_HAS_BEEN_OPENED_SUCCESSFULLY);
        } else {
            System.out.println(USER_MESSAGE.COULD_NOT_OPEN_FILE);
        }
    }

    /**
     * If the file-arrays size is more than 0, loop through the size of the file. And if the file isn't already sorted, call the 'sortContent'-method
     */
    private void sortFilesContents() {
        if (files.size() > 0) {
            for (TextFile file : files) {
                if (!file.isSorted()) {
                    file.sortContent();
                }
            }
            System.out.println(USER_MESSAGE.TEXT_FILES_ARE_SORTED);
        }else {
            System.out.println(USER_MESSAGE.NO_TEXT_FILE_IS_OPENED);
        }
    }

    /**
     * It's like a wizard that helps the user with looking for a word inside text files {@link #files} member variable..
     */
    private void searchInFiles() {
        if (files.size() > 0) {
            boolean filesContentsIsSorted = true, userDecision = false;
            // Checking if every opened text file content is sorted be checking sorted member value.
            for (TextFile file : files) {
                if (!file.isSorted()) {
                    filesContentsIsSorted = false;
                    break;
                }
            }
            // Let the user decide whether or not want to execute the searching in case contents is not sorted.
            if (!filesContentsIsSorted) {
                System.out.println(USER_MESSAGE.RECOMMENDATION_TO_SORT_FILES_BEFORE_SEARCHING);
                if (new Scanner(System.in).nextLine().equals("y")) {
                    System.out.println(USER_MESSAGE.WARNING_ABOUT_SIGNS);
                    userDecision = true;
                }
            }
            // Start searching.
            if (filesContentsIsSorted || userDecision) {
                System.out.println(USER_MESSAGE.SENSITIVE_CASE_SEARCH_NOTE);
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
        } else {
            System.out.println(USER_MESSAGE.NO_TEXT_FILE_IS_OPENED);
        }
    }

    /**
     * It sort search result and return a string that displays to the user.
     *
     * @param result unsorted search result.
     * @return a text that is readable by the user.
     */
    private String sortSearchResult(int[][] result) {
        StringBuffer resultText = new StringBuffer();
        //Sorting the result
        result = insertion(result);
        // Creating the text that show the result.
        for (int i = result.length - 1; i >= 0; i--) {
            // Get file name that is related to search result.
            String fileName = this.files.get(result[i][0]).getName();
            // To skipping the result of the files that don't contain the word.
            if (result[i][1] > 0) {
                resultText.append("Sökordet finns " + result[i][1] + " gånger i " + fileName + " filen.\n");
            } else {
                break;
            }                  //no need to continue because the result array is sorted.
        }
        if (resultText.toString().equals("")) {
            return USER_MESSAGE.NO_FILE_INCLUDE_SEARCH_KEYWORD;
        }
        return resultText.toString();
    }

    /**
     * It organizes the output of all opened files and prepare it to be readable by user.
     *
     * @return a string that hold the contents of all opened text files that stores inside {@link #files}.
     */
    private String getContents() {
        // In case the user has not opened a text file yet.
        if (files.size() == 0) {
            return USER_MESSAGE.NO_TEXT_FILE_IS_OPENED;
        } else {
            // Prepare the result that will be show to the user later.
            StringBuffer resultToPrint = new StringBuffer();
            for (TextFile file : files) {
                resultToPrint.append("Filnamn: " + file.getName() + "\n>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<\n" + file.getContent() + "\n________________________________________\n");
            }
            return resultToPrint.toString();
        }
    }

    /**
     * It's like a wizard that helps the user with saving the contents of the opened files {@link #files}.
     */
    private void saveFilesContents() {
        // Checking if the user has opened a text file.
        if (files.size() == 0) {
            System.out.println(USER_MESSAGE.NO_TEXT_FILE_IS_OPENED);
        } else {
            System.out.println(USER_MESSAGE.FILE_WILL_BE_SAVED_ON_DESKTOP);
            // Text file will be stored always in desktop "windows os"
            String desktopPath = System.getProperty("user.home") + "\\Desktop\\";
            StringBuffer fileName = new StringBuffer();
            boolean readyToSave = false;
            // Force the user to enter file name.
            while (fileName.length() == 0) {
                System.out.println(USER_MESSAGE.ASKING_TO_ENTER_FILE_NAME_THAT_WILL_BE_SAVED);
                // store the name
                fileName.replace(0, fileName.length(), new Scanner(System.in).nextLine());
                if (fileName.length() == 0) {
                    System.out.println(USER_MESSAGE.MUST_ENTER_A_NAME);
                }
            }

            // Checking if the file name has " .txt " at the end and added it in case it wasn't exist.
            if (fileName.length() > 4) {
                if (!fileName.substring(fileName.length() - 4).equals(".txt")) {
                    fileName.append(".txt");
                }
            } else {
                fileName.append(".txt");
            }
            // Checking if the file already exist and let the user decide to overwrite the file or not.
            boolean fileIsAlreadyExist = new File(desktopPath + fileName).exists();
            if (!fileIsAlreadyExist) {
                readyToSave = true;
            } else {
                System.out.println(USER_MESSAGE.FILE_ALREADY_EXIST);
                if (new Scanner(System.in).nextLine().equals("y")) {
                    readyToSave = true;
                }
            }
            // Calling the method that will save the file.
            if (readyToSave) {
                StringBuffer saveContent = new StringBuffer();
                files.forEach((file) -> saveContent.append(file.getContent() + "\n\n"));
                // Storing a message will be shown for the user.
                String msg = TextFile.save(saveContent.toString(),desktopPath + fileName.toString());
                System.out.println(msg);
            } else {
                System.out.println(USER_MESSAGE.FILE_HAS_NOT_BEEN_SAVED);
            }
        }
    }
    /**
     * It includes some messages that will be shown for the user.
     */
    public abstract static class USER_MESSAGE{
        // Console menu.
        private final static String CONSOLE_MENU =
                "\n\t(o) Öppna en ny fil och addera innehållet." +
                "\n\t(a) Skriva ut innehållet på alla öppnades filer." +
                "\n\t(b) Sortera de samtliga befintliga filerna. OBS! Onödiga tecken försvinner efter sortering." +
                "\n\t(c) Leta efter ett angivet ord." +
                "\n\t(d) Spara aktuella resultat i en externa text fil." +
                "\n\t(e) Avsluta Programmet." +
                "\n\t\tInmata ditt val:";

        /*Used inside start()*/
        public final static String GREETING = "\t\t>> Hej och välkommen till vår text-motor. <<";

        private final static String INVALID_SELECTION = "!!Ogiltigt val!! Välja gärna en giltig alternativ av lisatn nedan.";

        public final static String GOOD_BYE = "Hejdå och välkommen åter!!";

        /*Used inside openFile()*/
        private final static String ASKING_TO_ENTER_FILE_PATH = "Ange filväg som tillhör den önskad textfilen du vill öppna:";

        private final static String FILE_HAS_BEEN_OPENED_SUCCESSFULLY = "Det gick bra att öppna och addera filen.";

        private final static String COULD_NOT_OPEN_FILE = "!!Det gick tyvärr inte att öppna filen.!! \nSe till att filens format är '.txt' och att filen redan finns.";

        /*Used inside sortFilesContents()*/
        private final static String TEXT_FILES_ARE_SORTED = "Innehållet är sorterat.\nSkriv ut innehållet för att se resultatet.";

        public final static String NO_TEXT_FILE_IS_OPENED = "Du har inte öppnat någon textfil ännu!!";
        /*Used inside searchInFiles()*/
        private final static String RECOMMENDATION_TO_SORT_FILES_BEFORE_SEARCHING = "Jag rekomenderar att exekvera sökning på sorterad text för att få ett noggrannare resultat.Så sortera gärna texter först!!\nAnnars Jag kan fortfarande exekvera en sökning.\n Vill du fortsätta ändå? \n (y) ja, det vill jag. \n (Annars) Visa huvudmenyn.";

        private final static String WARNING_ABOUT_SIGNS = "!! Notera att vissa tecken kan räknas som en bokstav av ordet ifall det inte fanns ett mellanslag mellan dem.\n\t\tExemplvis: (. , : ! ? ) osv";

        private final static String SENSITIVE_CASE_SEARCH_NOTE = "!!Notera att sökningen är case-sensitive!!\nInmata gärna ordet du vill leta efter:";

        private final static String NO_FILE_INCLUDE_SEARCH_KEYWORD = "\t\t!!Ingen textfil innehåller sökordet!!";
        /*Used inside saveFilesContents()*/
        private final static String FILE_WILL_BE_SAVED_ON_DESKTOP = "OBS! Filen kommer att lagras på skrivbordet ifall det har lyckats.";

        private final static String ASKING_TO_ENTER_FILE_NAME_THAT_WILL_BE_SAVED = "Inmata ett namn på filen du vill spara!";

        private final static String MUST_ENTER_A_NAME = "Du måste ange ett namn!";

        private final static String FILE_ALREADY_EXIST = "Filen finns redan.\nVill du byta den aktuella filen?\n(y) Ja, det vill jag.\n (Annars) Visa huvudmenyn.";

        private final static String FILE_HAS_NOT_BEEN_SAVED = "!! Textfilen har inte sparats. !!";
    }
}