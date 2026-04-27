import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AutomobileInventory {

    public static void main(String[] args) {
        /* For the sake of demonstration this program automatically executes each of the
         * crucial methods required to run the Inventory. Methods are pre-loaded with
         * parameters and will therefore only return successful result messages.
         * In a true inventory unique Automobile objects would be created and destroyed,
         * but for the purposes of this exercise only one Automobile instance will be
         * created and modified.
         */
        Scanner scanner = new Scanner(System.in);
        Automobile myCar = null;
        
        try {
            System.out.println("=== Automobile Inventory Program ===\n");

            // create vehicle using parameterized constructor
            System.out.println("Step 1: Creating new vehicle object with parameterized constructor");
            System.out.print("Press Enter to continue");
            scanner.nextLine();
            myCar = new Automobile("Toyota", "Camry", "Silver", 2022, 45200);
            System.out.println("Vehicle created successfully using parameters \"Toyota\", \"Camry\", \"Silver\", 2022, 45200\n");
            
            // list current vehicle information
            System.out.println("Step 2: Displaying current vehicle information using listVehicleInformation() method");
            System.out.print("Press Enter to continue");
            scanner.nextLine();
            String[] info = myCar.listVehicleInformation();
            for (String line : info) {
                System.out.println(line);
            }
            System.out.println();
            
            /* remove vehicle really just erases attributes of a given Automobile object
             * alternatively, the object itself could be removed via objectName = null or
             * marked inactive
             */
            System.out.println("Step 3: Erasing current vehicle from inventory using removeVehicle() method");
            System.out.print("Press Enter to continue");
            scanner.nextLine();
            String removeResult = myCar.removeVehicle();
            System.out.println(removeResult + "\n");
            //info = myCar.listVehicleInformation(); 
            //for (String line : info) {
            //    System.out.println(line);
            //}
            //System.out.println();
            
            /* add a new vehicle just overrides values for the existing object since this program
             * does not feature an Arraylist of vehicles
             */
         
            System.out.println("Step 4: Adding a new vehicle with addNewVehicle() method");
            System.out.print("Press Enter to continue");
            scanner.nextLine();
            String addResult = myCar.addNewVehicle("Honda", "Accord", "Black", 2023, 12500);
            System.out.println(addResult + "\n");
            
            // Step 5: List updated vehicle
            System.out.println("Step 5: Displaying updated vehicle information");
            System.out.print("Press Enter to continue");
            scanner.nextLine();
            info = myCar.listVehicleInformation();
            for (String line : info) {
                System.out.println(line);
            }
            System.out.println();
            
            // Step 6: Update vehicle functions similarly to addNewVehicle()
            System.out.println("Step 6: Updating vehicle attributes");
            System.out.print("Press Enter to continue");
            scanner.nextLine();
            String updateResult = myCar.updateVehicle("Toyota", "Land Cruiser", "Silver", 2025, 2300);
            System.out.println(updateResult + "\n");
            
            // final object listing demonstration
            System.out.println("Step 7: Displaying final vehicle information");
            System.out.print("Press Enter to continue");
            scanner.nextLine();
            info = myCar.listVehicleInformation();
            for (String line : info) {
                System.out.println(line);
            }
            System.out.println();
            
            // printing to file demonstration
            System.out.print("Would you like to print the vehicle information to a file? (Y/N): ");
            String response = scanner.nextLine().trim().toUpperCase();

            if (response.equals("Y")) {
                printToFile(myCar);
            } else {
                System.out.println("No file will be printed.");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error in main program: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Helper method to write vehicle info to file
    private static void printToFile(Automobile myCar) {
        String filePath = "Autos.txt";

        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            
            pw.println("Vehicle Data Sheet");
            pw.println("============================");
            pw.println();

            String[] details = myCar.listVehicleInformation();
            for (String line : details) {
                pw.println(line);
            }

            System.out.println("Success: Vehicle information written to " + filePath);
            
        } catch (IOException e) {
            System.out.println("Failure: Could not write to file. Error: " + e.getMessage());
        }
    }
}