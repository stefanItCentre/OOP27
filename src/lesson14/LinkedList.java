package lesson14;

import lesson13.List;
import lesson15.hw.AbstractList;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by stefan on 08.09.16.
 */
public class LinkedList<E> extends AbstractList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public void add(E element) {
        add(size(), element);
    }

    @Override
    public void add(int idx, E element) {
        if(idx != size){
            checkIdx(idx);
        }
        Node<E> node = new Node<>(element);

        if(size == 0){
            last = first = node;
        } else if(idx == 0){
            node.next = first;
            first.prev = node;
            first = node;
        } else if(idx == size){
            node.prev = last;
            last.next= node;
            last = node;
        } else {
            Node<E> tmp = findNodeByIdx(idx);
            node.next = tmp;
            node.prev = tmp.prev;

            tmp.prev.next = node;
            tmp.prev = node;

        }
        size++;

    }

    @Override
    public E get(int idx) {
        return null;
    }

    @Override
    public E set(int idx, E element) {
        return null;
    }

    @Override
    public E remove(int idx) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void removeIf(Predicate<E> prd) {

    }

    @Override
    public <T> List<T> map(Function<E, T> func) {
        return null;
    }

    @Override
    public E reduce(BiFunction<E, E, E> func, E initial) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public List<E> subList(int fromIdx, int toIdx) {
        return null;
    }

    @Override
    public void clear() {
        while(!isEmpty()){
            remove(0);
        }
    }

//    @Override
//    public boolean addAll(List<? extends E> list) {
//        return addAll(size(), list);
//    }
//
//    @Override
//    public boolean getAll(List<? super E> stock) {
//        return false;
//    }

    @Override
    public boolean addAll(int idx, List<? extends E> c) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        if(size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for(Node<E> tmp = first; tmp != null; tmp = tmp.next){
            sb.append(tmp.value);
            if(tmp.next != null) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIter<>(this);
    }

    private static class MyIter<E> implements Iterator<E>{

        LinkedList<E> data;
        Node<E> current;

        public MyIter(LinkedList<E> list){
            data = list;
            current = data.first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E tmp = current.value;
            current = current.next;
            return tmp;
        }
    }

    private void checkIdx(int idx){
        if(idx < 0 || idx >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<E> findNodeByIdx(int idx){
        checkIdx(idx);
        Node<E> tmp = first;
        for(int i = 0; i < idx; i++){
            tmp = tmp.next;
        }
        return tmp;
    }


    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(20);
        list.add(10);
        list.add(5);
        list.add(9);
        list.add(0);

//        list.forEach(LinkedList::foo);

        for(Integer i : list){
            System.out.println(i);
        }


    }

    public static void foo(Integer f){

    }



    private static class Node<T>{
        Node<T> next;
        Node<T> prev;
        T value;

        public Node(T value) {
            this.value = value;
        }

        public Node(Node<T> next, Node<T> prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
