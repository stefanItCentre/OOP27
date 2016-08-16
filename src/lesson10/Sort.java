package lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by stefan on 16.08.16.
 */
public class Sort {

    public static void main(String[] args) {

        Integer [] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        String [] strArray = {"Hello", "World", "world", "hello", "abc", "ABC"};

//        Arrays.sort(array, new CompareDESC());
//
//        System.out.println(Arrays.toString(array));

        Arrays.sort(strArray, (s1, s2) -> -s1.compareToIgnoreCase(s2));

        System.out.println(Arrays.toString(strArray));



    }
}

class CompareStringIgnoreCase implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2) * -1;
    }
}

class CompareDESC implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 > o2){
            return -1;
        } else if(o1 < o2){
            return 1;
        }
        return 0;
    }
}
