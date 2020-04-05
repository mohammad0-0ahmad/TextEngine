package TextEngine.Tests.TextFile;

import TextEngine.TextFile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class that tests {@link TextEngine.TextFile#save(String, String)} method.
 */
public class Save {
    /**
     * Test that check returned message by passing invalid path.
     */
    @Test
    public void tryPassingInvalidPath(){
        assertEquals("Det går inte att hitta sökvägen", TextFile.save("Hello world!", "C:\\unexistFolder\\fileName.txt"));
    }
    @Test
    /**
     * Test that try creating a text file.
     */
    public void testSavingFileWithValidPath(){
        // File will be created at your desktop.
        assertEquals("Det gick bra med att spara fileName.txt filen.", TextFile.save("Hello world!!!", System.getProperty("user.home")+"\\Desktop\\fileName.txt"));
    }
}
