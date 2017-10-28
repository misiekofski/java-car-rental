import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

import static java.lang.Thread.sleep;

public class testRentalApp {
    Car hyundai;
    Car mazda;
    Car volvo;
    Car mercedes;
    static Collection<Car> carList = new HashSet<>();

    @Before
    public void setUpTest() {
        hyundai = new Car("DW1234", "Hyundai", "i30");
        mazda = new Car("DW5678", "Mazda", "RX5");
        volvo = new Car("DW6666", "Volvo", "S70");
        mercedes = new Car("D0 BUZI", "Mercedes", "Sprinter");
        carList.add(hyundai);
        carList.add(mazda);
        carList.add(mercedes);
        carList.add(volvo);
    }


    @Test
    public void testCarRentAndReturn() {
        hyundai.rentCar();
        hyundai.returnCar();
        hyundai.rentCar();
        boolean checkCarRental = hyundai.getRentStatus();
        Assert.assertTrue(checkCarRental);
    }

    @Test
    public void testCarList() {
        mercedes.rentCar();
        volvo.rentCar();
        Assert.assertEquals(carList.size(), 4);

    }
    @Test
    public void testCarRentalHistory() {
        mercedes.rentCar();
        mercedes.returnCar();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        mercedes.rentCar();
        mercedes.returnCar();
        try {
            Thread.sleep(4000);
        } catch (Exception e) {}
        mercedes.rentCar();
        mercedes.printRentalDates();
    }
}
