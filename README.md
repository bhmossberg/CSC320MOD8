# CSC320MOD8 – Portfolio Project: Automobile Inventory

The CSC320 portfolio project: an `Automobile` class with a demo program that runs its add, list, remove and update methods and can save the vehicle to a text file. Revised versions of earlier course programs are included alongside it.

## Overview

This is **CSU Global CSC320 (Programming I), Module 8**. It was committed as "Portfolio Initial Commit", followed by revisions up to "Version 1.2" (the version tag in the Javadoc). It is an Eclipse Java project. All sources are in `src/` in the default package. The text files in the repository root are the programs' input and output files, and they are read and written **relative to the working directory** (the project root when run from Eclipse).

## Portfolio project

### `Automobile.java`
A class that stores one vehicle in private fields: `make`, `model`, `color`, `year` and `mileage`.

| Member | Purpose |
|---|---|
| `Automobile()` | Default constructor; sets empty strings and zeros |
| `Automobile(make, model, color, year, mileage)` | Parameterized constructor |
| `String addNewVehicle(...)` | Sets all attributes and returns `"Success: <make> <model> (<year>) added."`, or a `Failure:` message if an exception is caught |
| `String[] listVehicleInformation()` | Returns the vehicle as five formatted lines (`Make: …`, `Model: …`, `Color: …`, `Year: …`, `Mileage: … miles`) |
| `String removeVehicle()` | Clears all attributes and returns a success message |
| `String updateVehicle(...)` | Calls `addNewVehicle` to reuse its logic |
| `String getFullInfo()` | Returns a CSV string (`make,model,color,year,mileage`) |

Every method returns a status string instead of printing, so the caller decides how to show results. Each one is wrapped in `try/catch` and reports failure.

### `AutomobileInventory.java` (main program)
A guided, step-by-step demo that pauses for **Enter** before each step:
1. Creates a `Toyota Camry 2022` with the parameterized constructor
2. Lists its information
3. Removes it with `removeVehicle()`
4. Adds a `Honda Accord 2023` with `addNewVehicle()`
5. Lists the updated vehicle
6. Updates it to a `Toyota Land Cruiser 2025, 2300 miles` with `updateVehicle()`
7. Lists the final vehicle, then asks **"print to a file? (Y/N)"**. On `Y`, `printToFile()` uses `PrintWriter(new FileWriter("Autos.txt"))` with try-with-resources to write a "Vehicle Data Sheet".

As the class comment says, the demo uses a single `Automobile` instance that it changes in place. There's no collection of vehicles.

`Autos.txt` in the repository is the output from a run where the user chose `Y`.

## Revised earlier programs

| File | Origin | What changed |
|---|---|---|
| `RestaurantInfo.java` | Module 1 | Stores the name, street and city/state/ZIP in variables and prints them with one `printf`. |
| `AverageWitholdingMarginal.java` | Module 3 | Progressive weekly tax calculator (10/15/20/30% brackets). It now rejects a salary of 0, uses `%n` line endings, and drops the commented-out test output. |
| `FloatingPointStats.java` | Module 4 | Restructured into methods. `getValidInput` allows 3 tries and checks entries against the regex `-?\d+\.?\d{0,2}` (at most two decimal places). `calculateSum`, `calculateAverage`, `findMax` and `findMin` work on a `double[]`. It reports the total, average, max, min and interest at a constant `INTEREST_RATE` of 20%. |
| `GetMonthlyTemperatures.java` | Module 5 | Same parallel-array month/temperature lookup, but invalid attempts are now counted only on failure, with an early exit after 3 ("Too many invalid attempts. Goodbye."). |
| `InputFileOutputFile.java` | New | File I/O demo. `readFile` loads `TestInput.txt` into a `StringBuilder`. `modifyContent` lets the user keep that text or type new lines ending with `END`. `printToFile` writes the result to `TestOutput.txt`. The committed `TestOutput.txt` shows a run where the user typed new text. |

## Build and run

JDK 8 or newer. From the repository root (so the `.txt` files are found and written there):

```bash
mkdir -p bin
javac -d bin src/*.java
java -cp bin AutomobileInventory     # press Enter at each step; answer Y to write Autos.txt
java -cp bin InputFileOutputFile     # reads TestInput.txt, writes TestOutput.txt
```

Sample output (verified, abridged):
```
=== Automobile Inventory Program ===

Step 1: Creating new vehicle object with parameterized constructor
Press Enter to continue
Vehicle created successfully using parameters "Toyota", "Camry", "Silver", 2022, 45200
...
Step 6: Updating vehicle attributes
Press Enter to continue
Success: Toyota Land Cruiser (2025) added.

Step 7: Displaying final vehicle information
Make: Toyota
Model: Land Cruiser
Color: Silver
Year: 2025
Mileage: 2300 miles

Would you like to print the following vehicle information to a file? (Y/N):
Toyota,Land Cruiser,Silver,2025,2300
```

## Concepts demonstrated
- Encapsulation: private fields, constructors (default and parameterized), and methods that return status strings
- Code reuse (`updateVehicle` delegates to `addNewVehicle`)
- Exception handling with `try/catch/finally` and try-with-resources
- File input (`FileInputStream` + `Scanner`) and output (`PrintWriter` + `FileWriter`)
- Input validation with regular expressions and attempt limits
- Javadoc comments (`@param`, `@return`, `@author`, `@version`)
