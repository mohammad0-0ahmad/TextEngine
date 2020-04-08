package TextEngine.Tests.UnitTests.Utilities;

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
        // Testing if it returns first word.
        test.append("Hello World!");
        assertEquals("Hello",getFirstWord(test)[0]);
        // Test if it returns first word if text start with whitespace.
        test.replace(0, test.length(), " Hello!");
        assertEquals("Hello!",getFirstWord(test)[0]);
        // Test if the rest of the text after removing first word.
        test.replace(0, test.length(), " Hello World!");
        assertEquals(" World!",getFirstWord(test)[1]);
        // Testing if the method will not remove some symbol like !
        test.replace(0, test.length(), " !Hello World!");
        assertEquals("!Hello",getFirstWord(test)[0]);
        //  Testing if the method will remove break line at first letter of the string.
        test.replace(0, test.length(), (char)Utilities.BREAK_LINE +"Hello World!");
        assertEquals("Hello",getFirstWord(test)[0]);
        // Test if it  will hold a break line that is first word.
        test.replace(0, test.length(), "\r\nHello\r\nWorld!");
        assertEquals("Hello\n",getFirstWord(test)[0]);
        // Test if it  will hold a tab that is after first word.
        test.replace(0, test.length(), (char)Utilities.TAB +"Hello World!");
        assertEquals((char)Utilities.TAB+"Hello",getFirstWord(test)[0]);
        // checking returned result by passing empty text.
        assertEquals("",getFirstWord(new StringBuffer())[0]);
    }
}
