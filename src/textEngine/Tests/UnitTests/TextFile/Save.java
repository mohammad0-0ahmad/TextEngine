package textEngine.Tests.UnitTests.TextFile;

import textEngine.TextFile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class that tests {@link textEngine.TextFile#save(String, String)} method.
 */
public class Save {
    /**
     * Test that check returned message by passing invalid path.
     */
    @Test
    public void tryPassingInvalidPath(){
        // This test will just work with windows that have a swedish language as interface language.
        assertEquals("Det går inte att hitta sökvägen", TextFile.save("Hello world!", "C:\\unexistFolder\\fileName.txt"));
        // This test will just work with windows that have a english language as interface language.
        //assertEquals("The system cannot find the path specified", TextFile.save("Hello world!", "C:\\unexistFolder\\fileName.txt"));

    }
    /**
     * Test that try creating a text file.
     */
    @Test
    public void testSavingFileWithValidPath(){
        // File will be created at your desktop.
        assertEquals("Det gick bra med att spara fileName.txt filen.", TextFile.save("Hello world!!!", System.getProperty("user.home")+"\\Desktop\\fileName.txt"));
    }
}
