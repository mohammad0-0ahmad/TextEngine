package TextEngine.Tests.TextFile;

import static TextEngine.TextFile.open;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class that tests TextFile.open method.
 */
class Open {
    /**
     * Test method that check the returned value by passing un exist text file.
     */
    @Test
    void openUnExistFiles(){
        try {
            assertNull(open("C:\\Users\\95mohahm\\Desktop\\test.txt"));
        }catch (Exception e){}

    }

    /**
     *Test method that check the returned value by passing other format files.
     */
    @Test
    void openOtherTypeFiles(){
        try {
            assertNull(open("C:\\Users\\95mohahm\\Desktop\\test.png"));
            assertNull(open("C:\\Users\\95mohahm\\Desktop\\test.pdf"));
            assertNull(open("C:\\Users\\95mohahm\\Desktop\\test.text"));
        }catch (Exception e){}
    }

}
