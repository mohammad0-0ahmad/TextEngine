package TextEngine.Tests.TextFile;

import TextEngine.TextFile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GetContent {
    @Test
    public void checkReturnedString(){
        //unsorted text
        TextFile test = new TextFile("test1", new StringBuffer("10a 9test? ,8sad 7 6 10a 9test? ,8sad 7 6 "));
        assertEquals("10a 9test? ,8sad 7 6 10a 9test? ,8sad 7 6", test.getContent());
        //sorted text
        TextFile test2 = new TextFile("test2", new StringBuffer("a b c d e f g h i j k l m n o"));
        assertEquals("a b c d e f g h i j\nk l m n o", test2.getContent());
    }
}
