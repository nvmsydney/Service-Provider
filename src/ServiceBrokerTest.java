/**************************************************************************************
 * JUnit Test Class for Service Broker
 * ***********************************************************************************
 * Function:
 * Tests service broker to ensure correct service is being called
 *--------------------------------------------------------------------------------------
 *
 * @author David Newman, Cameron Lohman
 * @version 04/21/2023 CMCS 355
 *************************************************************************************/
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceBrokerTest {

    private static final String TEST_FILE_PATH = "test_services.txt";
    private static final String TEST_FILE_CONTENT = "1,Service1\n2,Service2\n3,Service3\n";

    private File testFile;

    @BeforeEach
    public void setup() throws IOException {
        testFile = createTestFile();
    }

    @AfterEach
    public void cleanup() {
        deleteTestFile(testFile);
    }

    @Test
    public void testReadServicesFromFile() throws FileNotFoundException {
        HashMap<Integer, String> serviceMap = ServiceBroker.readServicesFromFile();

        assertEquals(3, serviceMap.size());
        assertEquals("DigitConverter", serviceMap.get(0));
        assertEquals("SkillsSearcher", serviceMap.get(1));
        assertEquals("Translator", serviceMap.get(2));
    }

    private File createTestFile() throws IOException {
        File file = new File(ServiceBrokerTest.TEST_FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(ServiceBrokerTest.TEST_FILE_CONTENT);
        }
        return file;
    }

    private void deleteTestFile(File file) {
        if (file != null && file.exists()) {
            assertTrue(file.delete());
        }
    }
}