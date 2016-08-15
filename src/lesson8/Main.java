package lesson8;

import lesson6.Car;

/**
 * Created by stefan on 09.08.16.
 */
public class Main {

    public static void main(String[] args) {

        Truck truck = new Truck("", 0, 0, 0, 0);

        Car truck2 = new Truck("");

        Car car = new Car("", 0, 0);

        truck2.drive(10);


        truck.drive(10);

        fill(truck);

        fill((Truck)truck2);

        fill((Truck)car);

//        truck.
    }



    public static void fill(Truck car){
        car.fill(20);
//        car.load();
    }


}
