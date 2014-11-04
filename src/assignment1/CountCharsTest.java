package assignment1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by THamilton on 6/4/2014.
 */
public class CountCharsTest {
    @Test
    public void testCountTheChar() throws Exception {
        CountChars test1 = new CountChars();
        char[] chars = "DuVEVxpSdMCkvtigSBvskPziEiiDzY".toCharArray();
        char ch = 'D';
        assertEquals("Both values should be the same.", 2, test1.countTheChar(chars, ch, chars.length));
    }
}
