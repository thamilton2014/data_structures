package assignment1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by THamilton on 6/4/2014.
 */
public class DBConvertTest {

    @Test
    public void testDecimalToBinary() throws Exception {
        DBConvert test = new DBConvert();
        assertEquals("The decimal 52 converted to binary is 110100", "110100", test.decimalToBinary(52));
    }
}
