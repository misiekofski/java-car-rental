import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class RentalApp {
	private static Collection<Vehicle> carList = new HashSet<>(); // tu trzymamy liste aut
	
	final static String MAIN_MENU = "1. Dodaj samochód\n2. Usuń samochód\n3. Edytuj samochód\n4. Sprawdź samochód\n" +
            "5. Wypożycz samochód\n6. Oddaj samochód\n7. Wyświetl statystyki\n0. Wyjdź z programu";
	final static String CAR_NOT_FOUND = "Car was not found in database.";

	static Scanner sc = new Scanner(System.in);

	public static void addCar(String registration) {
		String regNo = registration;
		for (Vehicle v : carList) {
			if (regNo.equals(v.getRegNumber())) {
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
		Vehicle temp = null;

		for (Vehicle v : carList) {
			if (regNo.equals(v.getRegNumber())) {
				carNotFound = false;
				temp = v;
			}
		}
		
		if (!carNotFound) {
			carList.remove(temp);
		}

		if (carNotFound) {
			System.out.println(CAR_NOT_FOUND);
		}
	}

	public static void editCar(String registration) {
		String regNo = registration;
		boolean carNotFound = true;

		for (Vehicle s : carList) {
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

		for (Vehicle s : carList) {
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

		for (Vehicle s : carList) {
			if (regNo.equals(s.getRegNumber())) {
				s.rentVehicle();
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

		for (Vehicle s : carList) {
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
		int choice;

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
			case 7:
				System.out.println("1. Wyświetl historię całej wypożyczalni.\n" +
						"2. Wyświetl historię wypożyczonego samochodu\n" +
						"3. Wyświetl statystyki.");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					printRentalHistory();
					break;
				case 2:
					printCarHistory();
					break;
				case 3:
					printStatistics();
					break;
				}
				break;
			case 0:
				quit = true;
				break;
			default:
				System.out.println("Option not available.");
			}
		} while (!quit);

	}

	private static void printStatistics() {
		int allCars=0, rentedCars=0, freeCars=0;

		for (Vehicle s : carList) {
			allCars+=1;
			if (s.getRentStatus()) rentedCars+=1;
			else freeCars+=1;
			}
		System.out.println("Number of all cars: "+allCars);
		System.out.println("Number of rented cars: "+rentedCars);
		System.out.println("Number of free cars: "+freeCars);
		}
		

	private static void printCarHistory() {
		String regNo = askForRegistration();
		for (Vehicle s : carList) {
			if (s.getRegNumber().equals(regNo)) {
				s.printRentalDates();
            }
        }
	}

	private static void printRentalHistory() {
		for (Vehicle s : carList) {
			s.printRentalDates();
		}
    }

}
