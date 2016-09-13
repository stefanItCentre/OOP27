package lesson15.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by stefan on 12.09.16.
 */
public class Task1 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6));


        Iterator<Integer> iter = list.iterator();

//        iter.remove();

        while(true){
            Integer elem = iter.next();
            if(elem.equals(2)){
                list.remove(0);
//                iter.remove();
            }
//            System.out.println(elem);
        }



//        for(Integer i : list){
//            System.out.println(i);
//        }
    }

}
