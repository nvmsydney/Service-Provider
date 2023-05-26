/**************************************************************************************
 * JUnit Test Class for Skills Search Service (Business Services)
 * ***********************************************************************************
 * Function:
 * Tests skills search to ensure it outputs the correct person(s)
 *--------------------------------------------------------------------------------------
 *
 * @author Sydney Nguyen, Cameron Lohman
 * @version 05/06/2023   CMCS 355
 *************************************************************************************/

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class SkillsSearcherTest {

    @Test
    public void testSkillsSearcher() {
        String data = "Strength\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        ByteArrayOutputStream stdout = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stdout);
        System.setOut(printStream);

        SkillsSearcher.main(new String[0]);

        String expectedOutput = "Mendoza, Diane\n";
        assertEquals(expectedOutput, stdout.toString());

        System.setIn(stdin);
        System.setOut(System.out);
    }
}
