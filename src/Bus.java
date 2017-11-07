public class Bus extends Vehicle {
    private int maximumLoad = 2000; // in kilograms
    private int rentalRate = 200;

    public Bus(String nrRej, String markaBusa, String modelBusa) {
        this.regNo = nrRej;
        this.producer = markaBusa;
        this.model = modelBusa;
        this.isVehicleRented = false;
    }
}