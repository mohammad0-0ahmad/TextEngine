package textEngine.Tests;

/**
 * A class that hold some variables that be used in System and Integration-tests
 */
public class VariablesUsedDuringTests {
    /**
     *  Text storing just english characters
     */
    public final static String TEXT_TEST = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mi mi, pellentesque et elementum nec, imperdiet id lorem. Nam ut tempus felis. Nunc erat velit, bibendum eu auctor eu, congue ut nisl. Nulla at purus nec erat interdum tempor ac id risus. Maecenas nisl felis, gravida in luctus id, posuere et mauris. Mauris rutrum varius libero, aliquet tempor risus gravida sed. Suspendisse nec odio ut tellus tincidunt convallis eu in diam. In volutpat maximus lectus. Maecenas fermentum facilisis nisl a faucibus. Nulla fringilla quam sit amet semper elementum. Sed nec consequat justo.";

    /**
     * 'TEXT_TEST' but sorted
     */
    public final static String SORTED_TEXT_TEST = "a ac adipiscing aliquet amet amet at auctor bibendum congue\n" +
            "consectetur consequat convallis diam dolor elementum elementum elit erat erat\n" +
            "et et eu eu eu facilisis faucibus felis felis fermentum\n" +
            "fringilla gravida gravida id id id imperdiet in in In\n" +
            "interdum ipsum justo lectus libero Lorem lorem luctus Maecenas Maecenas\n" +
            "mauris Mauris maximus mi mi Nam nec nec nec nec\n" +
            "nisl nisl nisl Nulla Nulla Nunc odio pellentesque posuere purus\n" +
            "quam risus risus rutrum Sed Sed sed semper sit sit\n" +
            "Suspendisse tellus tempor tempor tempus tincidunt ut ut ut varius\n" +
            "velit volutpat";

    /**
     * Text storing negative and positive numbers only.
     */
    public final static String NUMBERS_TEST ="12 90 27 39 4 48 29 15 55 93 43 100 50 72 75 96 1 69 37 47 49 28 61 79 14 33 24 56 78 44 86 34 81 74 64 71 26 70 20 40 54 65 32 85 67 11 77 89 21 22 83 94 13 30 97 36 18 42 19 82 8 2 57 68 53 58 9 25 38 98 60 92 52 45 23 91 31 88 6 3 95 80 87 84 46 99 66 62 10 73 63 51 41 5 35 76 17 16 7 59\n" +
            " -22 -54 -74 -42 -81 -77 -54 -32 -81 -12 -21 -69 -24 -82 -51 -31 -92 -42 -95 -12 -91 -23 -64 -48 -2 -74 -66 -36 -40 -53 -3 -56 -14 -93 -26 -54 -34 -19 -32 -6 -82 -30 -95 -13 -47 -4 -53 -24 -39 -77 -91 -72 -60 -55 -96 -72 -60 -43 -43 -35 -21 -4 -96 -80 -27 -32 -76 -26 -17 -3 -94 -63 -85 -78 -56 -91 -90 -73 -25 -30 -83 -21 -82 -45 -63 -88 -14 -50 -58 -88 -92 -70 -30 -73 -13 -98 -9";

    /**
     * 'NUMBER_TEST' but sorted
     */
    public final static String SORTED_NUMBER_TEST = "-98 -96 -96 -95 -95 -94 -93 -92 -92 -91\n" +
            "-91 -91 -90 -88 -88 -85 -83 -82 -82 -82\n" +
            "-81 -81 -80 -78 -77 -77 -76 -74 -74 -73\n" +
            "-73 -72 -72 -70 -69 -66 -64 -63 -63 -60\n" +
            "-60 -58 -56 -56 -55 -54 -54 -54 -53 -53\n" +
            "-51 -50 -48 -47 -45 -43 -43 -42 -42 -40\n" +
            "-39 -36 -35 -34 -32 -32 -32 -31 -30 -30\n" +
            "-30 -27 -26 -26 -25 -24 -24 -23 -22 -21\n" +
            "-21 -21 -19 -17 -14 -14 -13 -13 -12 -12\n" +
            "-9 -6 -4 -4 -3 -3 -2 1 2 3\n" +
            "4 5 6 7 8 9 10 11 12 13\n" +
            "14 15 16 17 18 19 20 21 22 23\n" +
            "24 25 26 27 28 29 30 31 32 33\n" +
            "34 35 36 37 38 39 40 41 42 43\n" +
            "44 45 46 47 48 49 50 51 52 53\n" +
            "54 55 56 57 58 59 60 61 62 63\n" +
            "64 65 66 67 68 69 70 71 72 73\n" +
            "74 75 76 77 78 79 80 81 82 83\n" +
            "84 85 86 87 88 89 90 91 92 93\n" +
            "94 95 96 97 98 99 100";

    /**
     * Text storing a combination of the 'TEXT_TEST' and 'NUMBER_TEST'
     */
    public final  static String COMBINATION_TEST = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mi mi, pellentesque et elementum nec, imperdiet id lorem. Nam ut tempus felis. Nunc erat velit, bibendum eu auctor eu, congue ut nisl. Nulla at purus nec erat interdum tempor ac id risus. Maecenas nisl felis, gravida in luctus id, posuere et mauris. Mauris rutrum varius libero, aliquet tempor risus gravida sed. Suspendisse nec odio ut tellus tincidunt convallis eu in diam. In volutpat maximus lectus. Maecenas fermentum facilisis nisl a faucibus. Nulla fringilla quam sit amet semper elementum. Sed nec consequat justo.\n" +
            " 12 90 27 39 4 48 29 15 55 93 43 100 50 72 75 96 1 69 37 47 49 28 61 79 14 33 24 56 78 44 86 34 81 74 64 71 26 70 20 40 54 65 32 85 67 11 77 89 21 22 83 94 13 30 97 36 18 42 19 82 8 2 57 68 53 58 9 25 38 98 60 92 52 45 23 91 31 88 6 3 95 80 87 84 46 99 66 62 10 73 63 51 41 5 35 76 17 16 7 59\n" +
            " -22 -54 -74 -42 -81 -77 -54 -32 -81 -12 -21 -69 -24 -82 -51 -31 -92 -42 -95 -12 -91 -23 -64 -48 -2 -74 -66 -36 -40 -53 -3 -56 -14 -93 -26 -54 -34 -19 -32 -6 -82 -30 -95 -13 -47 -4 -53 -24 -39 -77 -91 -72 -60 -55 -96 -72 -60 -43 -43 -35 -21 -4 -96 -80 -27 -32 -76 -26 -17 -3 -94 -63 -85 -78 -56 -91 -90 -73 -25 -30 -83 -21 -82 -45 -63 -88 -14 -50 -58 -88 -92 -70 -30 -73 -13 -98 -9";

    /**
     * 'COMBINATION_TEST' but sorted
     */
    public final static String SORTED_COMBINATION_TEST = "-98 -96 -96 -95 -95 -94 -93 -92 -92 -91\n" +
            "-91 -91 -90 -88 -88 -85 -83 -82 -82 -82\n" +
            "-81 -81 -80 -78 -77 -77 -76 -74 -74 -73\n" +
            "-73 -72 -72 -70 -69 -66 -64 -63 -63 -60\n" +
            "-60 -58 -56 -56 -55 -54 -54 -54 -53 -53\n" +
            "-51 -50 -48 -47 -45 -43 -43 -42 -42 -40\n" +
            "-39 -36 -35 -34 -32 -32 -32 -31 -30 -30\n" +
            "-30 -27 -26 -26 -25 -24 -24 -23 -22 -21\n" +
            "-21 -21 -19 -17 -14 -14 -13 -13 -12 -12\n" +
            "-9 -6 -4 -4 -3 -3 -2 1 2 3\n" +
            "4 5 6 7 8 9 10 11 12 13\n" +
            "14 15 16 17 18 19 20 21 22 23\n" +
            "24 25 26 27 28 29 30 31 32 33\n" +
            "34 35 36 37 38 39 40 41 42 43\n" +
            "44 45 46 47 48 49 50 51 52 53\n" +
            "54 55 56 57 58 59 60 61 62 63\n" +
            "64 65 66 67 68 69 70 71 72 73\n" +
            "74 75 76 77 78 79 80 81 82 83\n" +
            "84 85 86 87 88 89 90 91 92 93\n" +
            "94 95 96 97 98 99 100 a ac adipiscing\n" +
            "aliquet amet amet at auctor bibendum congue consectetur consequat convallis\n" +
            "diam dolor elementum elementum elit erat erat et et eu\n" +
            "eu eu facilisis faucibus felis felis fermentum fringilla gravida gravida\n" +
            "id id id imperdiet in In in interdum ipsum justo\n" +
            "lectus libero lorem Lorem luctus Maecenas Maecenas mauris Mauris maximus\n" +
            "mi mi Nam nec nec nec nec nisl nisl nisl\n" +
            "Nulla Nulla Nunc odio pellentesque posuere purus quam risus risus\n" +
            "rutrum sed Sed Sed semper sit sit Suspendisse tellus tempor\n" +
            "tempor tempus tincidunt ut ut ut varius velit volutpat";

    /**
     * Text using swedish characters
     */
    public final static String SWEDISH_TEST = "Löksås ipsum själv hwila där på har vid sitt, kanske för sitt kan äng oss samtidigt olika hwila, för dock kan samma bäckasiner se olika. Träutensilierna inom del nya trevnadens stig dag vad vemod hav hans räv blivit fram, där denna hans själv björnbär träutensilierna gamla se dunge lax nu. Och år sorgliga blev och tre oss rännil sällan hans, nu mjuka dimma genom regn enligt sällan dunge, brunsås för ingalunda trevnadens dimma i kan kom.\n";

    // Variable that holds some paths.
    /**
     * Desktop path.
     */
    public final static String DESKTOP_PATH = System.getProperty("user.home")+"\\Desktop\\";
    /**
     * The folder that stores all test files that have been used during test.
     */
    public final static String TEXTS_FOLDER_NAME = "TextFilesUsedWithTesting\\";
    /**
     * English text file path.
     */
    public final static String ENGLISH_TEXT_FILE_PATH = DESKTOP_PATH+TEXTS_FOLDER_NAME+"text1.txt";
    /**
     * Swedish text file path.
     */
    public final static String SWEDISH_TEXT_FILE_PATH = DESKTOP_PATH+TEXTS_FOLDER_NAME+"text2.txt";
    /**
     * Numbers text file path.
     */
    public final static String NUMBER_TEXT_FILE_PATH = DESKTOP_PATH+TEXTS_FOLDER_NAME+"text3.txt";
    /**
     * Path that refer to a text file which have combination of english words and some numbers as content.
     */
    public final static String ENGLISH_NUMBERS_TEXT_FILE_PATH = DESKTOP_PATH+TEXTS_FOLDER_NAME+"text4.txt";
}
