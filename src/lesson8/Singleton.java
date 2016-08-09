package lesson8;

/**
 * Created by stefan on 09.08.16.
 */
public class Singleton {

    public static final Singleton INSTANCE = new Singleton();


    private int val;

    private Singleton(){

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
