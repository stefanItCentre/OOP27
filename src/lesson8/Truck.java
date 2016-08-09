package lesson8;

import lesson6.Car;

/**
 * Created by stefan on 09.08.16.
 */
public class Truck extends Car{

    private int payLoad;
    private int foo;


    public Truck(String model){
         super(null, 0, 0);
    }

    public Truck(String model, double fuelConsumption, int mtc, int payLoad){
        super(model, fuelConsumption, mtc);
        this.payLoad = payLoad;
    }


    public Truck(String model, double fuelConsumption, int mtc, int payLoad, int foo){
        this(model, fuelConsumption, mtc, payLoad);
        this.foo = foo;

    }

    public void drive(int dst){
        System.out.println("Я грузовик!!! И я еду");
    }


    public void load(){

    }



}
