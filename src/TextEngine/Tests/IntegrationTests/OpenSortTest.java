package TextEngine.Tests.IntegrationTests;

import TextEngine.TextFile;
import org.junit.jupiter.api.Test;
import static TextEngine.Tests.VariablesUsedDuringTests.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * an integration test on {@link TextFile#open(String)} and {@link TextFile#sortContent()} methods.
 */
public class OpenSortTest {

    /**
     * Testing a random english text.
     */
    @Test
    public void textTest(){
       // open the related file.
       TextFile openedFile = TextFile.open(ENGLISH_TEXT_FILE_PATH);
       // checking the content after opening the file and before sorting the content.
        assertEquals(TEXT_TEST, openedFile.getContent());
       // sorting the content and checking the result then.
        openedFile.sortContent();
        assertEquals(SORTED_TEXT_TEST,openedFile.getContent());
    }

    /**
     * Testing a random amount of numbers.
     */
    @Test
    public void numbersTest(){
        // open the related file.
        TextFile openedFile = TextFile.open(NUMBER_TEXT_FILE_PATH);
        // checking the content after opening the file and before sorting the content.
        assertEquals(NUMBERS_TEST, openedFile.getContent());
        // sorting the content and checking the result then.
        openedFile.sortContent();
        assertEquals(SORTED_NUMBER_TEST,openedFile.getContent());
    }
    /**
     * Testing a random text that store a combination of english words and numbers.
     */
    @Test
    public  void combinationTest(){
        // open the related file.
        TextFile openedFile = TextFile.open(ENGLISH_NUMBERS_TEXT_FILE_PATH);
        // checking the content after opening the file and before sorting the content.
        assertEquals(COMBINATION_TEST, openedFile.getContent());
        // sorting the content and checking the result then.
        openedFile.sortContent();
        assertEquals(SORTED_COMBINATION_TEST,openedFile.getContent());
    }
}
