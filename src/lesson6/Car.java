package lesson6;

public class Car {
	
	private String model;

    private double fuelConsumption = 0.01;
    private double currentFuel;
    private int maxTankCapacity;
    private int mileage;
    private boolean start;
	

	public Car(String model, double fuelConsumption, int mtc){
		this.model = model;
		
//		this.fuelConsumption = fuelConsumption;
		maxTankCapacity = mtc;
	}

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public boolean isStart(){
        return start;
    }


    public double getCurrentFuel(){
        return currentFuel;
    }

    public int getMileage(){
        return mileage;
    }

	public void start() {
		start = currentFuel > 0;
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

		if(start){
			System.out.println("Я еду!!! =)");
            mileage += dst;
            currentFuel -= dst * fuelConsumption;
		} else {
			System.out.println("Заведи меня..");
		}
	}
	
	public void printInfo(){
		
		System.out.printf("Model : %10s, fuel : %05.2f, mileage : %05d, is start : %b%n", model, currentFuel, mileage, start);
	}


}
