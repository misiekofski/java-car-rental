import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;


public class testCarList {
	Collection<Car> carList = new HashSet<Car>();
	Car car1 = new Car("DDZ 4156", "Opel", "Kadet");
	Car car2 = new Car("DWR 6661", "Ford", "Fiesta");
	Car car3 = new Car("DW 4561", "Mitsubishi", "Lancer");
	Car car4 = new Car("D1 1234", "Hyundai", "i40");
	

	@Before
	public void init() throws Exception {
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		carList.add(car4);
	}

	@Test
	public void testRentAndReturnCar() {
	    fail ("Dupa!");
	}

}
