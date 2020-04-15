package TextEngine.Tests.UnitTests.TextFile;
import org.junit.jupiter.api.*;
import static TextEngine.TextFile.open;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test class that tests {@link TextEngine.TextFile#open(String)} method.
 */
class Open {
    /**
     * Test method that check the returned value by passing un exist text file.
     */
    @Test
    void openUnExistFiles(){
        try {
            assertNull(open("C:\\Users\\95jassod\\Desktop\\test.txt"));
        }catch (Exception ignored){}

    }

    /**
     *Test method that check the returned value by passing other format files.
     */
    @Test
    void openOtherTypeFiles(){
        try {
            assertNull(open("C:\\Users\\95jassod\\Desktop\\test.png"));
            assertNull(open("C:\\Users\\95jassod\\Desktop\\test.pdf"));
            assertNull(open("C:\\Users\\95jassod\\Desktop\\test.text"));
        }catch (Exception ignored){}
    }

}
