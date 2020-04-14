package textEngine.Tests.UnitTests.Sort;

import textEngine.Sort;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class that checks isSorted method.
 * link to the method {@link Sort#isSorted(ArrayList)} .
 */
public class IsSorted implements Sort {
    /**
     * Test checks if the method return correct values by passing sorted and unsorted arrayList.
     */
    @Test
    public void isReturnCorrectResult(){
        ArrayList<String> sorted = new ArrayList<>();
        sorted.add("abc");
        sorted.add("abd");
        sorted.add("abf");
        assertTrue(isSorted(sorted));
        // Test unsortedList
        ArrayList<String> unsorted = new ArrayList<>();
        sorted.add("abc");
        sorted.add("abf");
        sorted.add("abd");
        assertFalse(isSorted(sorted));
    }
}
