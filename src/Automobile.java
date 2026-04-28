	/**
	 * Represents a vehicle in the automobile inventory system.
	 * This class encapsulates vehicle attributes and provides methods
	 * for managing individual vehicle records.
	 * 
	 * @author Benjamin Mossberg
	 * @version 1.1
	 */
public class Automobile {

    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
   
    /**
     * Default constructor. Initializes all fields to default empty/zero values.
     */
    public Automobile() {
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
    }
   
    /**
     * Parameterized constructor to create a new Automobile with all attributes.
     * 
     * @param make     manufacturer of the vehicle
     * @param model    model name of the vehicle
     * @param color    color of the vehicle
     * @param year     model year of the vehicle
     * @param mileage  current mileage of the vehicle
     */
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }
    
    /**
     * Adds or replaces the current vehicle data.
     * 
     * @param make     the manufacturer
     * @param model    the model name
     * @param color    the color
     * @param year     the model year
     * @param mileage  the current mileage
     * @return success or failure message
     */
    public String addNewVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Success: " + make + " " + model + " (" + year + ") added.";
        } catch (Exception e) {
            return "Failure: " + e.getMessage();
        }
    }

    /**
     * Returns an array containing the current vehicle's information.
     * @return String array with vehicle details (one item per line)
     */
    public String[] listVehicleInformation() {
        try {
            return new String[]{
                "Make: " + make,
                "Model: " + model,
                "Color: " + color,
                "Year: " + year,
                "Mileage: " + mileage + " miles"
            };
        } catch (Exception e) {
            return new String[]{"Error retrieving vehicle info."};
        }
    }
    
    /**
     * Removes the current vehicle by clearing all its attributes.
     * @return success or failure message
     */
    public String removeVehicle() {
        try {
            this.make = this.model = this.color = "";
            this.year = this.mileage = 0;
            return "Success: Vehicle removed.";
        } catch (Exception e) {
            return "Failure: " + e.getMessage();
        }
    }
    
    /**
     * Updates the attributes of the current vehicle.
     * This method reuses the logic from addNewVehicle().
     * @param make     the new manufacturer
     * @param model    the new model name
     * @param color    the new color
     * @param year     the new model year
     * @param mileage  the new mileage
     * @return success or failure message
     */
    public String updateVehicle(String make, String model, String color, int year, int mileage) {
        return addNewVehicle(make, model, color, year, mileage); // reuse logic
    }

    /**
     * Returns a string of all vehicle attributes.
     * @return CSV-style string of vehicle data
     */
    public String getFullInfo() {
        return make + "," + model + "," + color + "," + year + "," + mileage;
    }
}