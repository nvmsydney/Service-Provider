/**************************************************************************************
 * JUnit Test Class for Translator Service (Business Services)
 * ***********************************************************************************
 * Function:
 * Tests translation services to ensure it has the correct output
 *--------------------------------------------------------------------------------------
 *
 * @author Sydney Nguyen
 * @version 04/21/2023 CMCS 355
 *************************************************************************************/

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class TranslatorTest {

    @Test
    public void englishToKlingon() throws FileNotFoundException {
        String englishWord = "Hello";
        String klingonWord = Translator.getTranslation(englishWord, "kl");
        assertEquals("nuqneH", klingonWord);
    }

    @Test
    public void englishToSpanish() {
        String englishWord = "cat";
        String spanishWord = Translator.getTranslation(englishWord, "es");
        assertEquals("gato", spanishWord);
    }

    @Test
    public void englishToGerman() {
        String englishWord = "cat";
        String germanWord = Translator.getTranslation(englishWord, "de");
        assertEquals("katz", germanWord);
    }

    @Test
    public void englishToFrench() {
        String englishWord = "friend";
        String frenchWord = Translator.getTranslation(englishWord, "fr");
        assertEquals("ami", frenchWord);
    }

    @Test
    public void testTranslationNotFound() {
        String englishWord = "orangutan";
        String klingonWord = Translator.getTranslation(englishWord, "kl");
        assertEquals(UtilityManager.getMessage(813), klingonWord);
    }

}

