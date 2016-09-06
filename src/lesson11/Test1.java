package lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by stefan on 22.08.16.
 */
public class Test1 {

    public static void main(String[] args) {

        new ArrayStack<String>(1);

//        ArrayList<String> list = new ArrayList<>(Arrays.asList("aaa", "sawd", "sawd", "sawd", "sawd"));
//
//
//        System.out.println(Math.pow(2, 2));
//
//        list.forEach(Test1::foo);
//
//        foo("efefewf");
//

//
//        list.removeIf(Test1::foo);

//        System.out.println(list);

//        apply("fooooooo", Test1::foo);

    }

    public static boolean foo(String str){
        return str.equals("aaa");
    }




    public static void apply(String arg, Function<String, String> func){
        System.out.println(func.apply(arg));
    }



}



