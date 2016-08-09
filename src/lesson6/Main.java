package lesson6;

public class Main {
	
	public static void main(String[] args) {
		Car car = new Car("ZAZ", 0.10, 50);
		


//        car.model = "";

		car.fill(10);
		car.start();

		car.drive(10);

        System.out.println(car.getMileage());

		car.printInfo();

		
		
	}

}
