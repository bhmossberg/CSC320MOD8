import java.util.Random;
import java.util.Scanner;
public class GetMonthlyTemperatures {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		// store the month and temperature in two different arrays for one year
		String[] months = {
	            "January", "February", "March", "April", "May", "June",
	            "July", "August", "September", "October", "November", "December"
	    };
		double[] temps = new double[12];
		// use Random to generate the temperature data for illustration purposes
		for (int i = 0; i < 12; i++) {
            temps[i] = 20.0 + random.nextDouble() * 65.0;  // random between 20 and 85 rounded to 1 decimal place
            temps[i] = Math.round(temps[i] * 10.0) / 10.0;
        }
		System.out.println("|===========================================|");
		System.out.println("|==========Get Monthly Temperature==========|");
		System.out.println("|===========================================|");
		// main program loop: prompt the user for the month/year 
		int attempts = 0;
		int maxAttempts = 3;
		while (true) {
			++attempts;
			if (attempts > maxAttempts) {
				System.out.println("Goodbye");
				break;
			}
			System.out.println("Enter month name to be viewed or 'year' to see all data. ");
			System.out.println("Type 'quit' to exit.");
			String input = sc.nextLine().trim();
			boolean found = false; //evaluate invalid input
	        // check for 'quit'
			if (input.equalsIgnoreCase("quit")) {
				System.out.print(("Goodbye"));
				break;
			}
			/*If "year" is entered display: 
				temperature for each month 
			  	yearly average 
			  	highest month temp 
			  	lowest month temp
			*/
	        else if (input.equalsIgnoreCase("year")) {
				found = true; //flag successful input
				attempts = 0;
				double sum = 0.0;
				// initialize high and low to [0] for iterative comparison
		        double highest = temps[0];
		        double lowest = temps[0];
		        // index to track position of high/low
		        int highIndex = 0;
		        int lowIndex = 0;

		        System.out.println("\nFull Year Temperature Data:");
		        // iterate through months to generate high, low, average
		        for (int i = 0; i < 12; i++) {
		        	// display each month with temperature
		            System.out.printf("%-10s: %.1f°F%n", months[i], temps[i]);
		            // build sum for calculating average
		            sum += temps[i];
		            // find high temperature
		            if (temps[i] > highest) {
		                highest = temps[i];
		                highIndex = i;
		            }
		            // find low temperature
		            if (temps[i] < lowest) {
		                lowest = temps[i];
		                lowIndex = i;
		            }
		        }
		        // calculate average
		        double yearlyAverage = sum / 12.0;
		   
		        System.out.println();
		        System.out.printf("Yearly Average: %.1f°F%n", yearlyAverage);
		        System.out.printf("Highest monthly average: %.1f°F (%s)%n", highest, months[highIndex]);
		        System.out.printf("Lowest monthly average: %.1f°F (%s)%n", lowest, months[lowIndex]);
		        System.out.println();   
		    }
				
			//search for month and output data
			else {
				for (int i = 0; i < months.length; i++) {
					if (months[i].equalsIgnoreCase(input)) {
						System.out.printf("%s: %.1f°F%n", months[i], temps[i]);
	                    found = true; // flag valid input
	                    attempts = 0; //reset invalid attempts
	                    break; // avoid continued iterating after successful match
	                }
				}
			}
			// invalid attempt error message with cumulative feedback
	        if ((!found)){
	            System.out.printf("Invalid input. %d of %d unsuccessful attempts.\n", attempts, maxAttempts); 
	        }
		}
		sc.close();		
	}

}
