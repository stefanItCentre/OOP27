package lesson12;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by stefan on 01.09.16.
 */
public class Test1 {

    public static void main(String[] args) {
        int [] array = {0, 0};

        int [] array2 = array;


        array[0] = 999;
        System.out.println(array2[0]);

//        new java.util.ArrayDeque<>().add()

    }

}
