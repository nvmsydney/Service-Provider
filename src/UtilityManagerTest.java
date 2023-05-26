/**************************************************************************************
 * JUnit Test Class for Utility Layer
 * ***********************************************************************************
 * Function:
 * Ensures correct error translation output
 *--------------------------------------------------------------------------------------
 *
 * @author Tracey Burruss, Sydney Nguyen
 * @version 04/21/2023 CMCS 355
 *************************************************************************************/

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class UtilityManagerTest {

    @Test
    public void testReturnMessageForEnglish() {
        Locale.setDefault(Locale.ENGLISH);
        assertEquals("Not found", UtilityManager.getMessage(404));
    }

    @Test
    public void testReturnMessageForGerman() {
        Locale.setDefault(Locale.GERMAN);
        assertEquals("Wort nicht gefunden", UtilityManager.getMessage(813));
    }

    @Test
    public void testReturnMessageForSpanish() {
        Locale.setDefault(new Locale("es"));
        assertEquals("No encontrado", UtilityManager.getMessage(404));
    }
}
