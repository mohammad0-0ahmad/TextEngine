package TextEngine.Tests.UnitTests.Sort;
import TextEngine.Sort;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test to see if values are sorted correctly
 */
class SortTest implements Sort{
    @Test
    /**
     * Tests if the 'partitioning'-method returns the last index closes to the 'pivot' correctly
     * also checks if the elements are sorted correctly
     */
    void TestIfItSorts() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Daniel");
        arrayList.add("Alexander");
        arrayList.add("Anna");
        arrayList.add("David");
        arrayList.add("Julia");
        arrayList.add("Joakim");
        arrayList.add("Kid");
        arrayList.add("Mattias");
        arrayList.add("Millad");
        arrayList.add("Simon");



        //the last element in the array
        int high = arrayList.size()-1;

        //expected value is 9 since the index closest to the pivot is returned
        assertEquals(9, partitioning(arrayList, 0, high));

        //expected value is the array-list but ordered
        quickSort(arrayList,0,high);
        assertEquals("Alexander",arrayList.get(0));
        assertEquals("Anna",arrayList.get(1));
        assertEquals("Daniel",arrayList.get(2));
        assertEquals("David",arrayList.get(3));
        assertEquals("Joakim",arrayList.get(4));
        assertEquals("Julia",arrayList.get(5));
        assertEquals("Kid",arrayList.get(6));
        assertEquals("Mattias",arrayList.get(7));
        assertEquals("Millad",arrayList.get(8));
        assertEquals("Simon",arrayList.get(9));
    }

}