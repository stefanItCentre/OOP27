package lesson9.shapes;

import java.util.ArrayList;

/**
 * Created by stefan on 15.08.16.
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Rectangle(10, 4));
        shapes.add(new Square(10));
        shapes.add(new Circle(4));
        shapes.add(new Square(8));
        shapes.add(new Circle(4));
        shapes.add(new Rectangle(5, 8));

        for(Shape s : shapes){
            System.out.println(s);
        }


        foo(new Circle(3));
        foo(new Rectangle(10, 10));



    }


    public static void f(double b){

    }

    public static void f(boolean b){

    }

    public static void foo(AbstractShape s){

    }
}
