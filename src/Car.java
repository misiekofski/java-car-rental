public class Car extends Vehicle {
    private int carSeats = 4;
    private int rentalRate;

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

    public void setColor(Color c) {
        this.color = c;
    }

    public void setRentalRate() {
        switch (color) {
            case RED:
                this.rentalRate = 150;
                break;
            case GREEN:
                this.rentalRate = 120;
                break;
            default:
                this.rentalRate = 100;
                break;
        }
    }

    public int getRentalRate() {
        return rentalRate;
    }
}