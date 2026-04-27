public class Automobile {

    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    public Automobile() {
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
    }

    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    // Add / Replace current vehicle data
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

    public String removeVehicle() {
        try {
            this.make = this.model = this.color = "";
            this.year = this.mileage = 0;
            return "Success: Vehicle removed.";
        } catch (Exception e) {
            return "Failure: " + e.getMessage();
        }
    }

    public String updateVehicle(String make, String model, String color, int year, int mileage) {
        return addNewVehicle(make, model, color, year, mileage); // reuse logic
    }

    // Getter for printing
    public String getFullInfo() {
        return make + "," + model + "," + color + "," + year + "," + mileage;
    }
}