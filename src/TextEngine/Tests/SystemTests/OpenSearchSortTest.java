package TextEngine.Tests.SystemTests;

import TextEngine.TextFile;
import org.junit.jupiter.api.Test;

import static TextEngine.Tests.VariablesUsedDuringTests.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * SystemTest-class used to test the efficiency of using Sort and Search simultaneously.
 */
public class OpenSearchSortTest {

    /**
     * Testing the efficiency of the opening file, sorting and searching methods in a text file with only words.
     */
    @Test
    public void textTest(){
        // opens the related file.
        TextFile openedFile = TextFile.open(ENGLISH_TEXT_FILE_PATH);
        assertEquals(TEXT_TEST, openedFile.getContent());
        // Sorts the content of the opened file.
        openedFile.sortContent();
        assertEquals(SORTED_TEXT_TEST,openedFile.getContent());
        // Looking for some words after sorting the content.
        assertEquals(1,openedFile.search("ipsum"));
        assertEquals(2,openedFile.search("Nulla"));
        // Unlike the integration test result this word will be cleaned of extra punctuation during sortContent method (before starting with sorting).
        // So the search result will be improved.
        assertEquals(3,openedFile.search("nisl"));
    }
    /**
     *Testing the efficiency of opening file, sorting and searching methods in a text file with only numbers.
     */
    @Test
    public void numberTest(){
        // Opens the related file.
        TextFile openedFile = TextFile.open(NUMBER_TEXT_FILE_PATH);
        assertEquals(NUMBERS_TEST, openedFile.getContent());
        // Sorts the content of the opened file.
        openedFile.sortContent();
        assertEquals(SORTED_NUMBER_TEST,openedFile.getContent());
        // Looking for some numbers after sorting the content.
        assertEquals(1,openedFile.search("82"));
        assertEquals(3,openedFile.search("-91"));
        assertEquals(3,openedFile.search("-82"));
    }
    /**
     *Testing the efficiency of opening file, sorting and searching methods in a text file with combination of english words and numbers.
     */
    @Test
    public void combinationTest(){
        // Opens the related file.
        TextFile openedFile = TextFile.open(ENGLISH_NUMBERS_TEXT_FILE_PATH);
        assertEquals(COMBINATION_TEST, openedFile.getContent());
        // Sorts the content of the opened file.
        openedFile.sortContent();
        assertEquals(SORTED_COMBINATION_TEST,openedFile.getContent());
        // Looking for some words after sorting the content.
        assertEquals(1,openedFile.search("ipsum"));
        assertEquals(2,openedFile.search("Nulla"));
        // Unlike the integration test result this word will be cleaned of extra punctuation during sortContent method (before starting with sorting).
        // So the search result will be improved.
        assertEquals(3,openedFile.search("nisl"));
        //looking for some numbers.
        assertEquals(1,openedFile.search("1"));
        assertEquals(1,openedFile.search("66"));
        assertEquals(2,openedFile.search("-53"));
    }
}
