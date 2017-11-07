public class Car extends Vehicle {
	private int carSeats = 4;

	public Car(String nrRej, String markaFury, String modelFury) {
		this.regNo = nrRej;
		this.producer = markaFury;
		this.model = modelFury;
		this.isVehicleRented = false;
	}
}
