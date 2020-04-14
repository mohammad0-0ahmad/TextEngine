package textEngine.Tests.UnitTests.Utilities;

import textEngine.Utilities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link Utilities#removeSigns(String)}test class.
 */
public class RemoveSigns implements Utilities {
    /**
     * test if removeSigns work without any problem with some possible input cases.
     */
    @Test
   public void isItRemoveSignsCorrectly(){
        // checking the right side of the passed value.
       assertEquals("Hello",removeSigns("Hello."));
       assertEquals("x+y",removeSigns("x+y"));
       assertEquals("",removeSigns("+"));
       assertEquals("Hello",removeSigns("Hello.*-/*/-*"));
       assertEquals("Hello@gmail.com",removeSigns("Hello@gmail.com.'/{)*"));
        // checking the left side of the passed value.
        assertEquals("Hello",removeSigns(",Hello"));
        assertEquals("15",removeSigns("+15"));
        assertEquals("Hello",removeSigns(".*-/*/-*Hello"));
        // Be sure that will keep negative numbers.
        assertEquals("-25",removeSigns("{-25}"));
        assertEquals("-2",removeSigns("{-2}"));
        assertEquals("",removeSigns("{-}"));
        // Checking that it will remove - at from the left edge in case the next character is a letter.
        assertEquals("Hello",removeSigns("{-Hello}"));
        // Checking swedish letters
        assertEquals("öron",removeSigns("{-öron}"));
        assertEquals("åka",removeSigns("{-åka}?"));
        assertEquals("älven",removeSigns("{-älven}?"));
        assertEquals("halvö",removeSigns("{-halvö}?"));
        // Testing sending a word that just have special signs in them.
        assertEquals("",removeSigns(":=)"));
    }
}
