package lesson11.homework;

import java.util.function.Consumer;

/**
 * Created by stefan on 22.08.16.
 */
public class Links {

    public static void main(String[] args) {
        Node n1 = new Node(19);
        Node n2 = new Node(10);
        Node n3 = new Node(4);
        Node n4 = new Node(8);
        Node n5 = new Node(9);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        process(n1, System.out::println);

        process(n1, System.out::print);
    }

    public static void process(Node first, Consumer<Node> cons){
        while(first != null){
            cons.accept(first);
            first = first.next;
        }
    }

}
