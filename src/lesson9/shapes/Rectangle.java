package lesson9.shapes;

/**
 * Created by stefan on 15.08.16.
 */
public class Rectangle extends Shape {

    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double perim() {
        return (sideA + sideB) * 2;
    }

    @Override
    public double area() {
        return sideA * sideB;
    }
}
