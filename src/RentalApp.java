import java.util.*;


public class RentalApp {
	static Collection<Car> carList = new HashSet<Car>();  // tu trzymamy liste aut
	final static String MAIN_MENU = "1. Dodaj samochód\n2. Usuń samochód\n3. Edytuj samochód\n4. Sprawdź samochód\n5. Wypożycz samochód\n6. Oddaj samochód\n0. Wyjdź z programu";
	final static String CAR_NOT_FOUND = "Car was not found in database.";
	static Scanner sc = new Scanner(System.in); 
	
	
	public static void addCar (){  
		System.out.println("Registration number: ");
		String regNo=sc.nextLine();
		System.out.println("Enter producer: ");
		String producer=sc.nextLine();
		System.out.println("Enter model: ");
		String model=sc.nextLine();

		carList.add(new Car(regNo, producer, model));

	}
	
	public static void deleteCar(){
		System.out.println("Enter registration to delete: ");
		String regNo = sc.nextLine();

		for (Car s : carList) {
			if (regNo.equals(s.getRegNumber())) {
				carList.remove(s);
			}
		}
	}
	
	public static void editCar(){
		System.out.println("Enter registration to edit: ");
		String regNo = sc.nextLine();
		for (Car s : carList) {
			if (regNo.equals(s.getRegNumber())) {
				// wywalamy
				carList.remove(s);
				//i tu trzeba dodać edytowany samochód ponownie
			}
		}
		
	}
	
	public static void checkCar(){
		System.out.println("Enter registration to rent: ");
		String regNo = sc.nextLine();
		boolean carNotFound = true;
		
		for (Car s : carList) {
			if (regNo.equals(s.getRegNumber())) {
					s.checkIsCarRented();
					carNotFound = false;
				}
			}
		
		if (carNotFound) {
			System.out.println(CAR_NOT_FOUND);
		}

	}

	
	public static void rentCar(){
		String regNo = sc.nextLine();
		System.out.println("Enter registration to rent: ");
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
	
	public static void returnCarToRental(){
		
		System.out.println("Enter registration to rent: ");
		String regNo = sc.nextLine();

		for (Car s : carList) {
			if (regNo.equals(s.getRegNumber())) {
				s.returnCar();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(MAIN_MENU);
		
		boolean quit = false;
		int menuItem;
		do {
			 System.out.print("Choose menu item: ");
             menuItem = sc.nextInt();
             sc.nextLine();
             switch (menuItem) {
             case 1:
            	   addCar();
                   break;
             case 2:
                   deleteCar();
                   break;
             case 3:
                   editCar();
                   break;
             case 4:
                   checkCar();
            	   break;
             case 5:
                   rentCar();
                   break;
             case 6:
                 returnCarToRental();
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
