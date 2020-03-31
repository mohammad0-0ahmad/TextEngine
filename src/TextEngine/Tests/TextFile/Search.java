package TextEngine.Tests.TextFile;

import TextEngine.TextFile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Search {
    @Test
    public void checkMethod() {
        // Testing a sorted data.
        TextFile test = new TextFile("test.txt", new StringBuffer("atest btest ctest dtest dtest dtest ztest"));
        assertEquals(0, test.search("test"));
        assertEquals(1, test.search("btest"));
        assertEquals(1, test.search("ztest"));
        assertEquals(1, test.search("atest"));
        assertEquals(3, test.search("dtest"));

        // Testing a unsorted data.
        test = new TextFile("test.txt", new StringBuffer("test ztest btest ctest dtest dtest dtest atest"));
        assertEquals(1, test.search("test"));
        assertEquals(1, test.search("btest"));
        assertEquals(1, test.search("ztest"));
        assertEquals(1, test.search("atest"));
        assertEquals(3, test.search("dtest"));


    }

}
