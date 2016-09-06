package lesson11;

/**
 * Created by stefan on 22.08.16.
 */
public class Test2 {

    public static void main(String[] args) {

//        test("bar", Test2::blabla);

        new Aa<String>().test((e) -> "").test((e)-> "");
    }

    public static void test (String arg, Foo f){
        System.out.println(f.foo(arg));
    }

    public static String blabla (String str){
        return new StringBuilder(str).reverse().toString();
    }
}

interface Foo<A, R>{

    R foo (A a);

}

class Aa<T> {

    public<N> Aa<N> test(Foo<T, N> foo){
        Aa<N> a = new Aa<>();
        a.take(foo.foo(get()));
        return a;
    }

    public T get(){
        return null;
    }

    public void take(T val){

    }
}
