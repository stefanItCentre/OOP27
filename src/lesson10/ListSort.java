package lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by stefan on 16.08.16.
 */
public class ListSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        Collections.sort(list);

        System.out.println(list);
    }
}

