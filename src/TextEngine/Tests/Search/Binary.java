package TextEngine.Tests.Search;

import TextEngine.Search;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Binary implements Search {

    @Test
    /**
     * Test checks if the method return correct values by passing different values.
     */
    public void isBinaryWorkCorrectly(){

        ArrayList<String> test = new ArrayList<String>();

        test.add("Hej");
        test.add("Hej1");
        test.add("Hej2");
        test.add("Hej3");
        test.add("Hej3");
        test.add("Hej4");
        test.add("Hej5");
        test.add("Hej5");
        test.add("Hej5");

        assertEquals(2,binary("Hej3",test));
        assertEquals(1, binary("Hej2", test));
        assertEquals(1, binary("Hej1", test));
        assertEquals(1, binary("Hej4", test));
        assertEquals(3, binary("Hej5", test));
        assertEquals(1, binary("Hej", test));

    }
}
