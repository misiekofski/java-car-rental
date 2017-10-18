import java.util.*;

public class RentalApp {
	static Collection<Car> carList = new HashSet<Car>(); // tu trzymamy liste
	// aut
	final static String MAIN_MENU = "1. Dodaj samochód\n2. Usuń samochód\n3. Edytuj samochód\n4. Sprawdź samochód\n5. Wypożycz samochód\n6. Oddaj samochód\n0. Wyjdź z programu";
	final static String CAR_NOT_FOUND = "Car was not found in database.";
	static Scanner sc = new Scanner(System.in);

	public static void addCar(String registration) {
		String regNo = registration;
		for (Car s : carList) {
			if (regNo.equals(s.getRegNumber())) {
				System.out.println("Car with this reg no exist in DB");
				return;
			}
		}
		System.out.println("Enter producer: ");
		String producer = sc.nextLine();
		System.out.println("Enter model: ");
		String model = sc.nextLine();

		carList.add(new Car(regNo, producer, model));
	}

	public static void deleteCar(String registration) {
		String regNo = registration;
		boolean carNotFound = true;

		for (Car s : carList) {
			if (regNo.equals(s.getRegNumber())) {
				carList.remove(s);
				carNotFound = false;
			}
		}

		if (carNotFound) {
			System.out.println(CAR_NOT_FOUND);
		}
	}

	public static void editCar(String registration) {
		String regNo = registration;
		boolean carNotFound = true;

		for (Car s : carList) {
			if (regNo.equals(s.getRegNumber())) {
				// wywalamy znaleziony samochód o znanej rejestracji
				carList.remove(s);
				// i tu trzeba dodać edytowany samochód ponownie
				System.out.println("Enter producer: ");
				String producer = sc.nextLine();
				System.out.println("Enter model: ");
				String model = sc.nextLine();
				carList.add(new Car(regNo, producer, model));
				carNotFound = false;
			}
		}

		if (carNotFound) {
			System.out.println(CAR_NOT_FOUND);
		}

	}

	public static void checkCar(String registration) {
		boolean carNotFound = true;

		for (Car s : carList) {
			if (registration.equals(s.getRegNumber())) {
				s.checkIsCarRented();
				carNotFound = false;
			}
		}

		if (carNotFound) {
			System.out.println(CAR_NOT_FOUND);
		}

	}

	public static void rentCarFromRental(String registration) {
		String regNo = registration;
		boolean carNotFound = true;

		for (Car s : carList) {
			if (regNo.equals(s.getRegNumber())) {
				s.rentCar();
				carNotFound = false;
			}
		}

		if (carNotFound) {
			System.out.println(CAR_NOT_FOUND);
		}

	}

	public static void returnCarToRental(String registration) {
		String regNo = registration;
		boolean carNotFound = true;

		for (Car s : carList) {
			if (regNo.equals(s.getRegNumber())) {
				s.returnCar();
				carNotFound = false;
			}
		}

		if (carNotFound) {
			System.out.println(CAR_NOT_FOUND);
		}

	}

	public static String askForRegistration() {
		System.out.println("Enter registration for car you want to process: ");
		String regNo = sc.nextLine();
		return regNo;
	}

	public static void main(String[] args) {
		System.out.println(MAIN_MENU);
		String regNo;

		boolean quit = false;
		int menuItem;
		do {
			System.out.print("Choose menu item: ");
			menuItem = sc.nextInt();
			sc.nextLine();
			switch (menuItem) {
			case 1:
				regNo = askForRegistration();
				addCar(regNo);
				break;
			case 2:
				regNo = askForRegistration();
				deleteCar(regNo);
				break;
			case 3:
				regNo = askForRegistration();
				editCar(regNo);
				break;
			case 4:
				regNo = askForRegistration();
				checkCar(regNo);
				break;
			case 5:
				regNo = askForRegistration();
				rentCarFromRental(regNo);
				break;
			case 6:
				regNo = askForRegistration();
				returnCarToRental(regNo);
				break;
			case 0:
				quit = true;
				break;
			default:
				System.out.println("Option not available.");
			}
		} while (!quit);

	}

}
