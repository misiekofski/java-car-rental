import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

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
    }

    @Test
    public void testCarList() {
    }

    @Test
    public void testCarRentalHistory() {
    }

    @Test
    public void testRentalPrice() {
        Car green = new Car("D1 6547", "Fiat Fiat", "Panda");
        green.setColor(Car.Color.GREEN);
        green.setRentalRate();
        Assert.assertEquals(green.getRentalRate(), 120);
        green.setColor(Car.Color.RED);
        Assert.assertEquals(green.getRentalRate(), 150);

    }
}
