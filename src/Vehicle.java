import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Vehicle {

    protected String regNo;
    protected String producer;
    protected String model;
    protected boolean isVehicleRented;
    protected List<Date> rentalDates = new ArrayList<>();

    @Override
    public String toString() {
        return "regNo: " + regNo + ", producer: " + producer + ", model: " + model + ", rented: " + isVehicleRented;
    }

    public void printVehicleData() {
        System.out.print("Vehicle: " + this.toString());
    }

    public void rentVehicle() {
        this.isVehicleRented = true;
        Date now = new Date();
        printVehicleData();
        System.out.println("was rented.");
        this.rentalDates.add(now);
    }

    public void returnCar() {
        this.isVehicleRented = false;
        printVehicleData();
        System.out.println("was returned back.");
    }

    public String getRegNumber() {
        return regNo;
    }

    public boolean getRentStatus() {
        return this.isVehicleRented;
    }

    public void checkIsVehicleRented() {
        if (this.isVehicleRented) {
            printVehicleData();
            System.out.println("is rented at this moment.");
        } else {
            printVehicleData();
            System.out.println("is available for rent.");
        }
    }

    public void printRentalDates() {
        printVehicleData();
        System.out.println();
        for (Date date : this.rentalDates) {
            System.out.println("Rented at :" + date.toString());
        }
    }
}
