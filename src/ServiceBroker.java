/**
 * Module:      Orchestration Services
 * Component:   Service Broker
 * **
 * Function:    Calls services with passed parameterized values.
 *              (Ultimately the middleman between UI and Services.)
 *----------------------------------------------------------------------------------------
 * Input:       Parameters – int: serviceCode, String: userInput
 * Output:      Return – Nothing, Runs service
 *----------------------------------------------------------------------------------------
 * @author:     David Newman, Sydney Nguyen, Cameron Lohman
 * @Version     04/21/2023   CMSC 355
 * **/

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;

public class ServiceBroker {
    private static final String SERVICES_FILE_PATH = "services.txt";

    public static void main(String[] args) throws Exception {
        HashMap<Integer, String> serviceMap = readServicesFromFile();

        Scanner scanner = new Scanner(System.in);

        String userInput = "";
        System.out.println("Choose a program to run:");
        printServiceOptions(serviceMap);
        System.out.println("Type 'exit' to quit");

        if (scanner.hasNextLine()) {
            userInput = scanner.nextLine();

            if (!userInput.equalsIgnoreCase("exit")) {
                try {
                    int serviceCode = Integer.parseInt(userInput);
                    String serviceName = serviceMap.get(serviceCode);

                    if (serviceName == null) {
                        System.out.println(UtilityManager.getMessage(703));
                    } else {
                        Class<?> serviceClass = Class.forName(serviceName);
                        Method mainMethod = serviceClass.getMethod("main", String[].class);
                        mainMethod.invoke(null, (Object) new String[0]);
                    }
                } catch (NumberFormatException | NoSuchMethodException | ClassNotFoundException e) {
                    System.err.println(UtilityManager.getMessage(404));
                } catch (Exception e) {
                    System.err.println(UtilityManager.getMessage(Integer.parseInt(e.getMessage())));
                }
            }
        }
    }

   public static HashMap<Integer, String> readServicesFromFile() throws FileNotFoundException {
        HashMap<Integer, String> serviceMap = new HashMap<>();

        try (Scanner input = new Scanner(new File(SERVICES_FILE_PATH))) {
            while (input.hasNext()) {
                String[] line = input.nextLine().split(",");
                int serviceID = Integer.parseInt(line[0]);
                String serviceName = line[1];
                serviceMap.put(serviceID, serviceName);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return serviceMap;
    }

    static void printServiceOptions(HashMap<Integer, String> serviceMap) {
        for (Integer serviceCode : serviceMap.keySet()) {
            System.out.println(serviceCode + " - " + serviceMap.get(serviceCode));
        }
    }
}