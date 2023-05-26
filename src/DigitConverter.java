import java.util.Scanner;

/**
 * Module:      Business Services
 * Component:   Digit Converter
 *
 * Function:    Convert any binary, octal, decimal, or hexadecimal value to another
 *              listed base.
 *----------------------------------------------------------------------------------------
 * Input:       Parameters - decimal value
 * Output:      Return - binary, octal, and hexadecimal conversions
 *----------------------------------------------------------------------------------------
 * @author:     Cameron Lohman, David Newman, Sydney Nguyen
 * @Version     04/21/2023   CMSC 355
 * **/

public class DigitConverter {
    public static void main(String[] args) {
        System.out.println("Enter a decimal number: ");
        Scanner input = new Scanner(System.in);

        int decimal = input.nextInt();

        String binary = Integer.toBinaryString(decimal);

        String octal = Integer.toOctalString(decimal);

        String hexadecimal = Integer.toHexString(decimal);

        System.out.println("Binary: " + binary);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hexadecimal);

        input.close();
    }
}