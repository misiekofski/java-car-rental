public class Car extends Vehicle {
    private int carSeats = 4;
    private int rentalRate = 100;

    public enum Color {RED, GREEN, WHITE, GRAY, BLACK, NOT_SET;}

    private Color color;

    public Car(String nrRej, String markaFury, String modelFury) {
        this.regNo = nrRej;
        this.producer = markaFury;
        this.model = modelFury;
        this.isVehicleRented = false;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setRentalRate() {
        switch (color) {
            case RED:
                this.rentalRate = 150;
            default:
                this.rentalRate = 120;
        }
    }

    public int getRentalRate() {
        return rentalRate;
    }
}