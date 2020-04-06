package TextEngine.Tests.Utilities;

import TextEngine.Utilities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link Utilities#isXBeforeY(String, String)} test class.
 */
public class IsXBeforeY implements Utilities {
    /**
     * a test That checks some possible input values.
     */
    @Test
    public void isItComparingCorrectly(){
        assertTrue(isXBeforeY("aba", "abb"));
        assertFalse(isXBeforeY("abs", "abb"));
        assertTrue(isXBeforeY("abs", "absa"));
        assertTrue(isXBeforeY("Abs", "abs"));
        assertTrue(isXBeforeY("Abs", "abs"));
        assertTrue(isXBeforeY("abs", "Abs"));
        assertFalse(isXBeforeY("Äbs", "zbs"));
        assertFalse(isXBeforeY("Ah", "aa"));
        assertTrue(isXBeforeY("Ah", "Ah!"));

        // testing if it compares correctly between tow numbers.
        assertTrue(isXBeforeY("9", "10"));
        assertTrue(isXBeforeY("1", "00001"));
        assertFalse(isXBeforeY("1", " 0"));
        assertFalse(isXBeforeY("1", "-1"));

        // testing if it compares correctly between a numbers and a word.
        assertTrue(isXBeforeY("10", "Hello"));
        assertFalse(isXBeforeY("Hello World","10"));
    }
}
