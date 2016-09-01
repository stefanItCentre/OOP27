package lesson12;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by stefan on 01.09.16.
 */
public class LinkedDeque implements Deque {

    private Node first;
    private Node last;
    private int size;

    @Override
    public boolean pushFirst(int elem) {
        if(size == 0){
            last = first = new Node(elem);
        } else {
            Node nd = new Node(elem);
            nd.prev = first;
            first.next = nd;
            first = nd;
        }
        size++;
        return true;
    }

    @Override
    public boolean pushLast(int elem) {
        return false;
    }

    @Override
    public Integer popFirst() {
        if(size == 0) return null;
        int tmp = first.value;
        if(first == last){
            first = last = null;
        } else {
            first = first.prev;
            first.next = null;
        }
        size--;
        return tmp;
    }

    @Override
    public Integer popLast() {
        return null;
    }

    @Override
    public Integer takeFirst() {
        return null;
    }

    @Override
    public Integer takeLast() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    public void forEachFirst(Consumer<Integer> cons){
        cons.accept(first.value);
    }

    public void forEachLast(Consumer<Integer> cons){

    }

    //*
    public Deque map(Function<Integer, Integer> mapper){
        return null;
    }



    @Override
    public String toString() {
        if(size == 0)return "[]";

        StringBuilder sb = new StringBuilder("[");

        for(Node nd = first; nd != null; nd = nd.prev){
            sb.append(nd.value);
            if(nd.prev != null){
                sb.append(", ");
            } else {
                sb.append("]");
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LinkedDeque deque = new LinkedDeque();

        deque.pushFirst(3);
        deque.pushFirst(1);
        deque.pushFirst(5);
        deque.pushFirst(7);
        deque.pushFirst(2);
        deque.pushFirst(4);

        Deque result = deque.map((e) -> (int)Math.pow(e, 2));



        deque.forEachFirst(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });


    }

    //inner class
//    class Node2{
//
//    }

    //nested class
    private static class Node{
        Node next;
        Node prev;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next, Node prev, int value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
