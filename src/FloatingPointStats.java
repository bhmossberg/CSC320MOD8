import java.util.Scanner;

public class FloatingPointStats {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX_VALUES = 5; // Programmable maximum number of values
        final double INTEREST_RATE = 0.20; // Programmable interest rate
        double[] values = new double[MAX_VALUES];

        System.out.printf("Enter %d amounts of money (maximum 2 decimal places).%n", MAX_VALUES);

        // Read all valid values
        for (int i = 0; i < MAX_VALUES; i++) {
            values[i] = getValidInput(sc, i + 1, MAX_VALUES);
            
            if (Double.isNaN(values[i])) {
                System.out.println("Program terminated due to too many invalid inputs.");
                sc.close();
                return;
            }
        }

        // Calculate results using dedicated methods
        double sum = calculateSum(values);
        double average = calculateAverage(sum, MAX_VALUES);
        double max = findMax(values);
        double min = findMin(values);
        double interest = sum * INTEREST_RATE;

        // Output results
        System.out.printf("%nTotal: $%.2f%n", sum);
        System.out.printf("Average: $%.2f%n", average);
        System.out.printf("Maximum: $%.2f%n", max);
        System.out.printf("Minimum: $%.2f%n", min);
        System.out.printf("Interest on total at %.0f%%: $%.2f%n", (INTEREST_RATE * 100), interest);

        sc.close();
    }

    // Gets a 2-decimal place floating point number with a maximum of 3 attempts
    private static double getValidInput(Scanner sc, int valueNumber, int totalValues) {
        int attempts = 0;
        final int MAX_TRIES = 3;

        while (attempts < MAX_TRIES) {
            System.out.printf("Enter value %d of %d: ", valueNumber, totalValues);
            String input = sc.nextLine().trim();

            // Check for valid number with at most 2 decimal places
            if (isValidTwoDecimalNumber(input)) {
                try {
                    return Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    // Should not reach here due to regex check, but kept for safety
                }
            }

            attempts++;
            if (attempts == MAX_TRIES) {
                System.out.println("Too many failed inputs. Closing Program.");
                return Double.NaN;
            } else {
                System.out.println("Invalid entry. Please enter a valid number with at most 2 decimal places.");
            }
        }
        return Double.NaN;
    }

    // Validates if number is two decimal places at most and contains at least one digit.
    private static boolean isValidTwoDecimalNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        // Regex: must have at least one digit and no more than two decimal places
        return input.trim().matches("-?\\d+\\.?\\d{0,2}");
    }
    
    // Returns sum of all values as double
    private static double calculateSum(double[] values) {
        double sum = 0.0;
        for (double v : values) {
            sum += v;
        }
        return sum;
    }

    // Returns average of all values as double
    private static double calculateAverage(double sum, int count) {
        return sum / count;
    }

    // Returns maximum value as double
    private static double findMax(double[] values) {
        double max = values[0];
        for (double v : values) {
            if (v > max) max = v;
        }
        return max;
    }

    // Returns minimum value as double
    private static double findMin(double[] values) {
        double min = values[0];
        for (double v : values) {
            if (v < min) min = v;
        }
        return min;
    }
}