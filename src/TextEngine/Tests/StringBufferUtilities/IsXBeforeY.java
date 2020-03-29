package TextEngine.Tests.StringBufferUtilities;

import TextEngine.Utilities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
        assertFalse(isXBeforeY("Ah", "aa!"));
        assertFalse(isXBeforeY("1", "00001"));
        assertFalse(isXBeforeY("1", " 0"));
        assertFalse(isXBeforeY("1", "-1"));
    }
}
