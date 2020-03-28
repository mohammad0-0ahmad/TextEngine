package TextEngine.Tests.TextFile;

import static TextEngine.TextFile.open;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Open {
    /**
     * Test method that check the returned value by passing un exist text file.
     */
    @Test
    void openUnExistFiles() {
        assertNull(open("C:\\Users\\95mohahm\\Desktop\\test.txt"));
    }
}
