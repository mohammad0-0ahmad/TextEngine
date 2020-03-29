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

        Assert.assertEquals(arrayListSorted, sorting(arrayList));
    }
}