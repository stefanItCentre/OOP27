package lesson9.shapes;

/**
 * Created by stefan on 15.08.16.
 */
public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double perim() {
        return radius * 2 * Math.PI;
    }

    @Override
    public double area() {
        return Math.pow(radius, 2) * Math.PI;
    }
}
