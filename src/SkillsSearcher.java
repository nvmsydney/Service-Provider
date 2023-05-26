import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Module:      Business Services
 * Component:   Skills Searcher
 *
 * Function:    Search for a crew mate by best skill
 *--------------------------------------------------------------------------------------
 * Input:       Parameters - Skill
 * Output:      Return – Employee first name and last name
 *--------------------------------------------------------------------------------------
 * @author:     Cameron Lohman, Sydney Nguyen, and Muniza Siddiqui
 * @version:    04/21/2023     CMCS 355
 * **/

public class SkillsSearcher {
    public static void main(String[] args) {
        /* ***************************************************************************
         *   Declare Variables:
         *   input          -           file to be read
         *   scanner        -           scanner object to read inputted skill
         *   targetSkill    -           inputted skill by the user
         *   exit           -           boolean value that determines whether to exit program
         *   line           -           each line in the file
         *   firstName      -           first name in the file
         *   lastName       -           last name in the file
         *   skills         -           skill listed in the file
         *****************************************************************************/
        Scanner scanner = new Scanner(System.in);
        String targetSkill = scanner.nextLine();

        List<String> name = new ArrayList<>();
        try {
            // OPEN crew_manifest.txt IN SCANNER:
            Scanner input = new Scanner(new File("C:\\Users\\melos\\IdeaProjects\\Spring-2023-Team-13\\src\\crew_manifest.txt"));
            while (input.hasNextLine()) {
                // GET INPUT VIA FILE:
                String line = input.nextLine();
                String[] parts = line.split(",");

                // ERROR CATCH: (INVALID LINE)
                if (parts.length != 3) {
                    System.err.println("Invalid line: " + line);
                    continue;
                }

                // RETRIEVE VARS FOR LINE:
                String lastName = parts[0].trim();
                String firstName = parts[1].trim();
                String skill = parts[2].trim();

                // CHECK USER INPUT FOR SKILL:
                if (targetSkill.equalsIgnoreCase(skill)) {
                    // ADD NAME TO THE STRING LIST:
                    name.add(lastName + ", " + firstName + "\n");
                }
            }
            // CLOSE INPUT SCANNER:
            input.close();
        }
        // ERROR CATCH:
        catch (FileNotFoundException e) {
            System.err.println("File not found: crew_manifest.txt");
        }
        // WRITE NAMES TO THE UI GLOBAL STRING OUTPUT:
        for (String name1 : name){
            System.out.print(name1);
        }

    }
}