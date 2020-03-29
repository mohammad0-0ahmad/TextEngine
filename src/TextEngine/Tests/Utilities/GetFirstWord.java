package TextEngine.Tests.Utilities;

import TextEngine.Utilities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link Utilities#getFirstWord(StringBuffer)} test class.
 */
public class GetFirstWord implements Utilities {
    @Test
    /**
     * Checks the method with different cases of parameters.
     */
    public void isItReturnFirstWord(){
        StringBuffer test = new StringBuffer("");
        getFirstWord(test);
        assertEquals("",getFirstWord(test)[0]);
        test.append("Hello World!");
        assertEquals("Hello",getFirstWord(test)[0]);
        test.replace(0, test.length(), " Hello!");
        assertEquals("Hello!",getFirstWord(test)[0]);
        test.replace(0, test.length(), " Hello World!");
        assertEquals("Hello",getFirstWord(test)[0]);
        test.replace(0, test.length(), " !Hello World!");
        assertEquals("!Hello",getFirstWord(test)[0]);
        test.replace(0, test.length(), (char)Utilities.BREAK_LINE +"Hello World!");
        assertEquals((char)Utilities.BREAK_LINE+"Hello",getFirstWord(test)[0]);
        test.replace(0, test.length(), (char)Utilities.TAB +"Hello World!");
        assertEquals((char)Utilities.TAB+"Hello",getFirstWord(test)[0]);
        assertEquals("",getFirstWord(new StringBuffer())[0]);

    }
}
