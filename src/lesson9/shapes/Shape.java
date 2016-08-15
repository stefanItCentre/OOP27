package lesson9.shapes;

/**
 * Created by stefan on 15.08.16.
 */
public class Shape {

    public double area(){
        return 0;
    }

    public double perim(){
        return 0;
    }


    @Override
    public String toString() {
        return String.format("%s, perim : %05.2f, area : %05.2f", getClass().getName(),  perim(), area());
    }

    public void draw(int x, int y){

    }

    public int [] getPath(){

        return null;
    }
}
