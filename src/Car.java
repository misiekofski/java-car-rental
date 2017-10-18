public class Car {

	private String regNo;
	private String producer;
	private String model;
	private boolean isCarRented;
	
    public Car (String nrRej, String markaFury, String modelFury) {
        this.regNo = nrRej;
        this.producer = markaFury;
        this.model = modelFury;
        this.isCarRented = false;
    }
    
    public void printCarData(){
		System.out.print("Car " + this.producer + 
				" " + this.model +
				" with reg no: " + this.regNo + " ");
    }
    
    public void rentCar(){
    	this.isCarRented = true;
		printCarData();
		System.out.println("was rented.");
    }
    
    public void returnCar(){
    	this.isCarRented = false;
    	printCarData();
		System.out.println("was returned back.");
    }
    
    public String getRegNumber() {
    	return regNo;
    }
    
    public String getProducer() {
    	return producer;
    }
    
    public String getModel() {
    	return model;
    }
    
    public void checkIsCarRented() {
    	if (this.isCarRented) {
    		printCarData();
    		System.out.println("is rented at this moment.");
    	} else {
    		printCarData();
    		System.out.println("is available for rent.");
    	}
    }
    

}
