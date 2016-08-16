package lesson9.shapes;

import java.io.Serializable;

/**
 * Created by stefan on 15.08.16.
 */
public abstract class AbstractShape implements Shape {



    public abstract String getName();



    @Override
    public String toString() {
        return String.format("%s, perim : %05.2f, area : %05.2f", getName(),  perim(), area());
    }

}
