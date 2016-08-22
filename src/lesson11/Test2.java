package lesson11;

/**
 * Created by stefan on 22.08.16.
 */
public class Test2 {

    public static void main(String[] args) {

        test("bar", Test2::blabla);

    }

    public static void test (String arg, Foo f){
        System.out.println(f.foo(arg));
    }

    public static String blabla (String str){
        return new StringBuilder(str).reverse().toString();
    }
}

interface Foo{

    String foo (String str);

}
