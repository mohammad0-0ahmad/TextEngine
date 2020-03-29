package TextEngine.Tests.Sort;

import TextEngine.Sort;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class that checks isSorted method see.
 * link to the method {@link Sort#isSorted(ArrayList)} .
 */
public class IsSorted implements Sort {
    @Test
    /**
     * Test checks if the method return correct values by passing sorted and un sorted arrayList.
     */
    public void isReturnCorrectResult(){
        ArrayList<String> sorted = new ArrayList<String>();
        sorted.add("abc");
        sorted.add("abd");
        sorted.add("abf");
        assertTrue(isSorted(sorted));
        // Test unsortedList
        ArrayList<String> unsorted = new ArrayList<String>();
        sorted.add("abc");
        sorted.add("abf");
        sorted.add("abd");
        assertFalse(isSorted(sorted));
    }
}
