import java.io.*;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class UtilityManager {
    public static void main(String[] args) {
        if (args.length > 0) {
            int errorCode = Integer.parseInt(args[0]);
            String message = getMessage(errorCode);
            System.out.println(message);
        }
    }

    public static String getMessage(int errorCode) {
        Properties props = new Properties();
        String lang = Locale.getDefault().getLanguage();
        try (InputStream input = UtilityManager.class.getClassLoader().getResourceAsStream("message.properties")) {
            props.load(input);
            String fileName = props.getProperty(lang);
            try (Scanner scanner = new Scanner(new File(fileName))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    int code = Integer.parseInt(parts[0].trim());
                    if (code == errorCode) {
                        return parts[1].trim();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "An error occurred. Please try again later.";
    }
}