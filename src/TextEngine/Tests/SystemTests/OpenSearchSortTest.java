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
     * Testing the efficiency of the sorting and searching-methods in a text file with only words
     */
    @Test
    public void textTest(){
        TextFile openedFile = TextFile.open(System.getProperty("user.home")+"\\Desktop\\TextFilesUsedWithTesting\\text.txt");
        assertEquals(TEXT_TEST, openedFile.getContent());

        openedFile.sortContent();
        assertEquals(SORTED_TEXT_TEST,openedFile.getContent());

        assertEquals(1,openedFile.search("ipsum"));
        assertEquals(2,openedFile.search("Nulla"));
        assertEquals(3,openedFile.search("nisl"));
    }
    /**
     *Testing the efficiency of sorting and searching-methods in a text file with only numbers
     */
    @Test
    public void numberTest(){
        TextFile openedFile = TextFile.open(System.getProperty("user.home")+"\\Desktop\\TextFilesUsedWithTesting\\text3.txt");

        assertEquals(NUMBERS_TEST, openedFile.getContent());

        openedFile.sortContent();
        assertEquals(SORTED_NUMBER_TEST,openedFile.getContent());

        assertEquals(1,openedFile.search("82"));
        assertEquals(3,openedFile.search("-91"));
        assertEquals(3,openedFile.search("-82"));
    }
    /**
     * TODO whitespace= difference in identical text
     */
    /*@Test
    public void combinationTest(){
        TextFile openedFile = TextFile.open(System.getProperty("user.home")+"\\Desktop\\TextFilesUsedWithTesting\\text4.txt");

        assertEquals(COMBINATION_TEST, openedFile.getContent());


        openedFile.sortContent();
        System.out.println(openedFile.getContent());
        //assertEquals(SORTED_COMBINATION_TEST,openedFile.getContent());

        assertEquals(1,openedFile.search("ipsum"));
        assertEquals(2,openedFile.search("Nulla"));
        assertEquals(2,openedFile.search("nisl"));    }*/
}
