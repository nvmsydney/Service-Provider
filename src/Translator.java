import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Module:      Business Services
 * Component:   Translator
 *
 * Function:    Translates inputted English word into Klingon
 *----------------------------------------------------------------------------------------
 * Input:       Parameters – String: English Word
 * Output:      Return – String: Translated word
 *----------------------------------------------------------------------------------------
 * @author:     Cameron Lohman, Sydney Nguyen, & Muniza Siddiqui
 * @Version     05/06/2023   CMSC 355
 * **/

    public class Translator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String languageCode = scanner.nextLine();
        String message = getTranslation(word, languageCode);
        System.out.println(message);
    }

        public static String getTranslation(String word, String languageCode) {
            Properties props = new Properties();
            try (InputStream input = Translator.class.getClassLoader().getResourceAsStream("translation.properties")) {
                props.load(input);
                String fileName = props.getProperty(languageCode);
                if (fileName == null) {
                    return UtilityManager.getMessage(805);
                }
                try (Scanner scanner = new Scanner(new File(fileName))) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] parts = line.split(",");
                        String key = parts[0].toLowerCase().trim();
                        String value = parts[1].trim();
                        if (key.equalsIgnoreCase(word)) {
                            return value;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return UtilityManager.getMessage(813);
        }
    }

