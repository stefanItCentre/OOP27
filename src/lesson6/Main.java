package lesson6;

public class Main {
	
	public static void main(String[] args) {
		Car car = new Car(null, -0.10, 0);
		
		
		car.maxTankCapacity = 150;
		car.fuelConsumption = -0.09;
		car.model = "KAMAZ";
		
		
		car.fill(10);
		car.start();
		car.drive(10);
		
		car.printInfo();
		
		
	}

}
