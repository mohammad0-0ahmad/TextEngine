package TextEngine.Tests.Utilities;

import TextEngine.Utilities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link Utilities#removeSigns(String)}test class.
 */
public class RemoveSigns implements Utilities {

    @Test
    /**
     * test if removeSigns work without any problem with some possible input cases.
     */
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
        assertEquals("25",removeSigns("{-25}"));
    }
}
