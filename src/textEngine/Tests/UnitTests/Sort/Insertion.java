package textEngine.Tests.UnitTests.Sort;

import textEngine.Sort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class that checks insertion method.
 * link to the method {@link Sort#insertion(int[][])}.
 */
public class Insertion implements Sort {
  /**
     * Test checks if the method return correct values by passing a matrix.
     */
    @Test
    public void checkReturnedValue(){
        int [][] test = new int[][]{{0,4},{1,3},{2,2},{3,0}};
        //expected array {{3,0},{2,2},{1,3},{0,4}}
        // item 1
        assertEquals(3,insertion(test)[0][0]);
        assertEquals(0,insertion(test)[0][1]);
        // item 2
        assertEquals(2,insertion(test)[1][0]);
        assertEquals(2,insertion(test)[1][1]);
        // item 3
        assertEquals(1,insertion(test)[2][0]);
        assertEquals(3,insertion(test)[2][1]);
        // item 4
        assertEquals(0,insertion(test)[3][0]);
        assertEquals(4,insertion(test)[3][1]);

        // test empty matrix
        assertNull(insertion(new int[0][]));
        // test matrix have 3 columns
        assertNull(insertion(new int[1][3]));
    }
}
