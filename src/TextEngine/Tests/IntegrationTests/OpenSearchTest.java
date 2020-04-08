package TextEngine.Tests.IntegrationTests;

import TextEngine.TextFile;
import org.junit.jupiter.api.Test;
import static TextEngine.Tests.IntegrationTests.VariablesUsedDuringThisTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * an integration test on {@link TextFile#open(String)} and {@link TextFile#search(String)} methods.
 * The following tests is runs on unsorted data with other words It depends on linear searching algorithm and punctuation will be calculated as letter.
 */
public class OpenSearchTest{
    /**
     * Testing random english text.
     */
    @Test
    public void textSearchTest(){
        // open the related file.
        TextFile openedFile = TextFile.open(System.getProperty("user.home")+"\\Desktop\\TextFilesUsedWithTesting\\text.txt");
        // checking the content after opening the file and before sorting the content.
        assertEquals(TEXT_TEST , openedFile.getContent());
        // looking for some words.
        assertEquals(1,openedFile.search("ipsum"));
        assertEquals(2,openedFile.search("Nulla"));
        // this word is exist 3 times but because of one of them have a punctuation so they become 2 instead of 3.
        assertEquals(2,openedFile.search("nisl"));
    }

    /**
     * Testing random swedish text.
     */
    @Test
    public void swedishSearchTest(){
        // open the related file.
        TextFile openedFile = TextFile.open(System.getProperty("user.home")+"\\Desktop\\TextFilesUsedWithTesting\\text2.txt");
        // checking the content after opening the file and before sorting the content.
        assertEquals(SWEDISH_TEST, openedFile.getContent());
        // looking for some words.
        assertEquals(1,openedFile.search("dock"));
        assertEquals(1,openedFile.search("nu"));
        assertEquals(1,openedFile.search("nu."));
        // The following tow lines show that when looking for "hans" the search result will not include hans, that have a comma at the end.
        assertEquals(2,openedFile.search("hans"));
        assertEquals(1,openedFile.search("hans,"));

    }

    /**
     * Testing random numbers.
     */
    @Test
    public void numberSearchTest(){
        // open the related file.
        TextFile openedFile = TextFile.open(System.getProperty("user.home")+"\\Desktop\\TextFilesUsedWithTesting\\text3.txt");
        // checking the content after opening the file and before sorting the content.
        assertEquals(NUMBERS_TEST, openedFile.getContent());
        // looking for some numbers.
        assertEquals(1,openedFile.search("82"));
        assertEquals(3,openedFile.search("-91"));
        assertEquals(3,openedFile.search("-82"));
    }

}
