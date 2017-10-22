import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class testRentalApp {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCarClass() {
        Car hyundai = new Car("DW1234", "Hyundai", "i30");
        hyundai.rentCar();
        hyundai.returnCar();
        hyundai.rentCar();
        boolean checkCarRental = hyundai.getRentStatus();
        Assert.assertTrue(checkCarRental==true);
    }
}
