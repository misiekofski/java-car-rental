import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Car {

	private String regNo;
	private String producer;
	private String model;
	private boolean isCarRented;
	private List<Date> rentalDates = new ArrayList<>();

	public Car(String nrRej, String markaFury, String modelFury) {
		this.regNo = nrRej;
		this.producer = markaFury;
		this.model = modelFury;
		this.isCarRented = false;
	}

	public void printCarData() {
		System.out.print("Car " + this.producer + " " + this.model
				+ " with reg no: " + this.regNo + " ");
	}

	public void rentCar() {
		this.isCarRented = true;
		Date now = new Date();
		printCarData();
		System.out.println("was rented.");
		this.rentalDates.add(now);
	}

	public void returnCar() {
		this.isCarRented = false;
		printCarData();
		System.out.println("was returned back.");
	}

	public String getRegNumber() {
		return regNo;
	}

//  I thought that returning object by RegNo was a good idea...
//	public Car getCarByRegNo(String number) {
//		if (this.regNo.equals(number)) return this;
//		else return null;
//	}

	
	public boolean getRentStatus() {
		return this.isCarRented;
	}

	public void checkIsCarRented() {
		if (this.isCarRented) {
			printCarData();
			System.out.println("is rented at this moment.");
		} else {
			printCarData();
			System.out.println("is available for rent.");
		}
	}

	public void printRentalDates() {
		printCarData();
		System.out.println();
	    for (Date date : this.rentalDates) {
			System.out.println("Rented at :" + date.toString());
		}
	}

}
