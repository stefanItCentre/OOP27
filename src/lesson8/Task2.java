package lesson8;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by stefan on 09.08.16.
 */
public class Task2 {

    public static void main(String[] args) {

//        Singleton s = new Singleton();

        Singleton s = Singleton.INSTANCE;

        s.setVal(20);

        System.out.println(Singleton.INSTANCE.getVal());



    }
}
