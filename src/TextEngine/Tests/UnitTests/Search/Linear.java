package TextEngine.Tests.UnitTests.Search;

import TextEngine.Search;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class that checks linear method.
 * link to the method {@link Search#linear(String, ArrayList)} .
 */
public class Linear implements Search {
    @Test
    /**
     * Test checks if the method return correct values by passing different values.
     */
    public void checkIfItWorkCorrectly(){
        ArrayList <String> test = new ArrayList<String>();
        test.add("hello1");
        test.add("hello2");
        test.add("hello3");
        test.add("hello4");
        test.add("hello5");
        assertEquals(1,linear("hello5",test));
        test.add("hello4");
        assertEquals(2,linear("hello4",test));
        test.add("hello4");
        assertEquals(3,linear("hello4",test));
        assertEquals(0,linear("hello",test));
        // the word should be same the word in the array list.
        assertEquals(0,linear("hello4,",test));
        // when passing array list that is empty.
        test = new ArrayList<String>();
        assertEquals(-1,linear("hello4,",test));
        // when passing array list that is null.
        test = null;
        assertEquals(-2,linear("hello4,",test));
    }
}
