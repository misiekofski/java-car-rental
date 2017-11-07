public class Motor extends Vehicle {
    private int motorSeats = 2;
    private int rentalRate = 50;

    public Motor(String nrRej, String markaMoto, String modelMoto) {
        this.regNo = nrRej;
        this.producer = markaMoto;
        this.model = modelMoto;
        this.isVehicleRented = false;
    }
}