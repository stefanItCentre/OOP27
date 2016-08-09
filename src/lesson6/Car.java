package lesson6;

public class Car {
	
	String model;
	double fuelConsumption = 10;
	double currentFuel;
	int maxTankCapacity;
	int mileage;
	boolean isStart;
	
	
	
	public Car(String model, double fuelConsumption, int mtc){
		this.model = model;
		
//		this.fuelConsumption = fuelConsumption;
		maxTankCapacity = mtc;
	}

	
	public void start() {
		isStart = currentFuel > 0;
	}
	
	public void fill(double currentFuel){
		if(this.currentFuel + currentFuel > maxTankCapacity){
			this.currentFuel = maxTankCapacity;
		} else {
			this.currentFuel += currentFuel;
		}
		
//		currentFuel += fuel;
//		if(currentFuel > maxTankCapacity){
//			currentFuel = maxTankCapacity;
//		}
	}
	
	public void drive(int dst) {
		if(isStart){
			System.out.println("Я еду!!! =)");			
		} else {
			System.out.println("Заведи меня..");
		}
	}
	
	public void printInfo(){
		
		System.out.printf("Model : %10s, fuel : %05.2f, mileage : %05d, is start : %b%n", model, currentFuel, mileage, isStart);
	}

}
