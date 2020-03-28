package TextEngine.Tests.StringBufferUtilities;

import TextEngine.StringBufferUtilities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountWordsAmount implements StringBufferUtilities {
    @Test
    public void isITCountCorrectly(){
        StringBuffer test = new StringBuffer();
        assertEquals(0, countWordsAmount(test));
        test.append("test");
        assertEquals(1, countWordsAmount(test));
        test.append(" test test");
        assertEquals(3, countWordsAmount(test));
    }
    @Test
    public void unRegularText(){
        StringBuffer test = new StringBuffer();
        test.append(" \n \t ");
        assertEquals(0, countWordsAmount(test));
        test.append("\ntest ");
        assertEquals(1, countWordsAmount(test));
        test.append("   test test   ");
        assertEquals(3, countWordsAmount(test));
        test.append("< ? d");
        assertEquals(6, countWordsAmount(test));
        test.append(" .");
        assertEquals(7, countWordsAmount(test));
    }
}
