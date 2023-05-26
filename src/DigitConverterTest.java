/**************************************************************************************
 * JUnit Test Class for Number Conversion Service (Business Services)
 * ***********************************************************************************
 * Function:
 * Tests number conversions to ensure it has the correct output
 *--------------------------------------------------------------------------------------
 *
 * @author Cameron Lohman, Sydney Nguyen
 * @version 05/06/2023      CMCS 355
 *************************************************************************************/

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitConverterTest {

    @Test
    public void testBinaryConversion() {
        int decimal = 10;
        String binary = "1010";
        assertEquals(binary, Integer.toBinaryString(decimal));
    }

    @Test
    public void testOctalConversion() {
        int decimal = 10;
        String octal = "12";
        assertEquals(octal, Integer.toOctalString(decimal));
    }

    @Test
    public void testHexadecimalConversion() {
        int decimal = 10;
        String hexadecimal = "a";
        assertEquals(hexadecimal, Integer.toHexString(decimal));
    }
}
