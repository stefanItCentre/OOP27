package lesson9;

/**
 * Created by stefan on 15.08.16.
 */
public class Task1 {

    public static void main(String[] args) {

        A b = new B(10);
        A a = new A(10);

//        System.out.println(b);


        System.out.println("test " + b);

    }


}




class A {
    private int a;
    int b;


    public A(int a) {
        this.a = a;
    }

    final public int getA(){
        return a;
    }

    public void g(){
        System.out.println("g()");
    }


}

class B extends A {

    public B(int a) {
        super(a);
    }

    public void g(){
        System.out.println("g(int)");
    }

    @Override
    public String toString(){
        return "Hello from B()";
    }

}
