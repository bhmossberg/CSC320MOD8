import java.util.Random;
import java.util.Scanner;

public class GetMonthlyTemperatures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Month names and temperature array
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        double[] temps = new double[12];

        // Generate random temperatures (20.0°F to 85.0°F, 1 decimal place)
        for (int i = 0; i < 12; i++) {
            temps[i] = 20.0 + random.nextDouble() * 65.0;
            temps[i] = Math.round(temps[i] * 10.0) / 10.0;
        }

        System.out.println("|===========================================|");
        System.out.println("|==========Get Monthly Temperature==========|");
        System.out.println("|===========================================|");

        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (true) {
            System.out.println("\nEnter month name to be viewed or 'year' to see all data.");
            System.out.println("Type 'quit' to exit.");

            String input = sc.nextLine().trim();

            // Handle quit - Improved: Consistent message and clean break
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye");
                break;
            }

            boolean found = false;

            // Handle "year" request
            if (input.equalsIgnoreCase("year")) {
                found = true;
                attempts = 0;  // Reset attempts on valid input

                double sum = 0.0;
                double highest = temps[0];
                double lowest = temps[0];
                int highIndex = 0;
                int lowIndex = 0;

                System.out.println("\nFull Year Temperature Data:");
                for (int i = 0; i < 12; i++) {
                    System.out.printf("%-10s: %.1f°F%n", months[i], temps[i]);
                    sum += temps[i];

                    if (temps[i] > highest) {
                        highest = temps[i];
                        highIndex = i;
                    }
                    if (temps[i] < lowest) {
                        lowest = temps[i];
                        lowIndex = i;
                    }
                }

                double yearlyAverage = sum / 12.0;
                System.out.printf("%nYearly Average: %.1f°F%n", yearlyAverage);
                System.out.printf("Highest monthly average: %.1f°F (%s)%n", highest, months[highIndex]);
                System.out.printf("Lowest monthly average: %.1f°F (%s)%n", lowest, months[lowIndex]);
            }
            // Handle specific month
            else {
                for (int i = 0; i < months.length; i++) {
                    if (months[i].equalsIgnoreCase(input)) {
                        System.out.printf("%s: %.1f°F%n", months[i], temps[i]);
                        found = true;
                        attempts = 0;            // Reset attempts on valid input
                        break;
                    }
                }
            }

            // Invalid input handling improvement
            // Attempts now only increment on failure rather than relying on reset
            // Cleaner logic with early exit instead of fragile top-of-loop counter
            if (!found) {
                attempts++;
                if (attempts >= MAX_ATTEMPTS) {
                    System.out.println("Too many invalid attempts. Goodbye.");  // Consistent message
                    break;
                } else {
                    System.out.printf("Invalid input. %d of %d unsuccessful attempts.%n",
                                    attempts, MAX_ATTEMPTS);
                }
            }
        }

        sc.close();   // Proper resource cleanup
    }
}