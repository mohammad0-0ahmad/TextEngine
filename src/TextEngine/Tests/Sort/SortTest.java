package TextEngine.Tests.Sort;

import TextEngine.Sort;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class SortTest implements Sort{
    @Test
    void SortingBasedOnAlphabeticalOrder() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Strings");
        arrayList.add("Are");
        arrayList.add("For");
        arrayList.add("Dummies");

        ArrayList<String> arrayListSorted = new ArrayList<>();
        arrayListSorted.add("Are");
        arrayListSorted.add("Dummies");
        arrayListSorted.add("For");
        arrayListSorted.add("Strings");

        String high = arrayList.get(arrayList.size() - 1); //Getting the first string in the array
        int highest = arrayList.indexOf(high);

        String low = arrayList.get(0); //Getting the first string in the array
        int lowest = arrayList.indexOf(low);


        Assert.assertEquals(1, partitioning(arrayList, lowest, highest));
        Assert.assertEquals(arrayList, sort(arrayList, lowest, highest));

    }
}