package lesson15.hw;

/**
 * Created by stefan on 12.09.16.
 */
import lesson13.List;
import lesson7.*;

import java.lang.Number;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


class LinkedList<E> extends AbstractList<E> implements List<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    @Override
    public void add(int idx, E element) {

        if (idx != size) {
            checkIdx(idx);
        }
        Node<E> node = new Node<>(element);

        if (size == 0) {
            first = last = node;
        } else if (idx == 0) {
            first.prev = node;
            node.next = first;
            first = node;
        } else if (idx == size) {
            last.next = node;
            node.prev = last;
            last = node;
        } else {
            Node<E> tmp = findNodeByIdx(idx);
            tmp.prev.next = node;
            node.prev = tmp.prev;
            node.next = tmp;
            tmp.prev = node;
        }
        size++;

    }

    @Override
    public E get(int idx) {
        Node<E> node = findNodeByIdx(idx);
        if (node.elem != null) {
            return node.elem;
        }
        return null;
    }

    @Override
    public E set(int idx, E element) {
        Node<E> tmp = findNodeByIdx(idx);
        if (element != null) {
            E delValue=tmp.elem;
            tmp.elem = element;
            return delValue;
        }
        return null;
    }

    @Override
    public E remove(int idx) {
        Node<E> node = findNodeByIdx(idx);
        E tmp = node.elem;
        remove(node);
        return tmp;
    }

    private void remove(Node<E> node){
        if(first == last){
            first = last = null;
        } else if(node == first){
            first = first.next;
            first.prev = null;
        } else if(node == last){
            last = last.prev;
            last.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    @Override
    public boolean remove(Object o) {
//        int counter = 0;
        if (o == null) {
            for (Node<E> tmp = first; tmp != null; tmp = tmp.next) {
//                counter++;
                if (tmp.elem == null) {
                    remove(tmp);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
//                counter++;
                if (o.equals(x.elem)) {
                    remove(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void removeIf(Predicate<E> prd) {
        for (Node<E> nd = first; nd != null; nd = nd.next) {
            if (prd.test(nd.elem)) {
                remove(nd);
            }
        }
    }

//    @Override
//    public void forEach(Consumer<E> cons) {
//        for (Node<E> nd = first; nd != null; nd = nd.next) {
//            cons.accept(nd.elem);
//        }
//    }




    @Override
    public void clear(){
//        while (isEmpty()) {
//            remove(0);
//        }
        first = last = null;
        size = 0;
    }



    @Override
    public <T> List<T> map(Function<E, T> func) {
        List<T> result = new LinkedList<>();
        for (Node<E> nd = first; nd != null; nd = nd.next) {
            result.add(func.apply(nd.elem));
        }
        return result;
    }

    @Override
    public E reduce(BiFunction<E, E, E> func, E initial) {
        E result = initial;
        for (Node<E> nd = first; nd != null; nd = nd.next) {
            result = func.apply(result, nd.elem);
        }
        return result;
    }

    @Override
    public int indexOf(Object o) {
        int counter = 0;

        if(o == null){
            for (Node<E> nd = first; nd != null; nd = nd.next, counter++) {
                if (nd.elem == null) {
                    return counter;
                }

            }
        }else {
            for (Node<E> nd = first; nd != null; nd = nd.next, counter++) {
                if (o.equals(nd.elem)) {
                    return counter;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int counter = size;

        if(o == null){
            for (Node<E> nd = last; nd != null; nd = nd.prev) {
                counter--;
                if (nd.elem == null) {
                    return counter;
                }
            }
        }else {
            for (Node<E> nd = last; nd != null; nd = nd.prev) {
                counter--;
                if (o.equals(nd.elem)) {
                    return counter;
                }
            }
        }
        return -1;
    }

    @Override
    public List<E> subList(int fromIdx, int toIdx) {
        if(fromIdx<0 || toIdx > size() || fromIdx > toIdx) {
            throw new IndexOutOfBoundsException();
        }

        List<E> result = new LinkedList<>();
        Node<E> tmp = first;

        for (int i = 0; i < fromIdx; i++){
            tmp = tmp.next;
        }

        for (int i = fromIdx; i < toIdx; i++) {
            result.add(tmp.elem);
            tmp = tmp.next;
        }

        return result;
    }

    @Override
    public boolean addAll(int idx, List<? extends E> c) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder("[");

        for (Node nd = first; nd != null; nd = nd.next) {
            sb.append(nd.elem);
            if (nd.next != null) {
                sb.append(", ");
            } else {
                sb.append("]");
            }
        }
        return sb.toString();
    }


    private void checkIdx(int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException(String.valueOf(idx));
        }
    }

    private Node<E> findNodeByIdx(int idx) {
        checkIdx(idx);
        Node<E> tmp;
        if(idx < size / 2){
            tmp = first;
            for (int i = 0; i < idx; i++) {
                tmp = tmp.next;
            }
        } else {
            tmp = last;
            for(int i = size - 1; i > idx; i--){
                tmp = tmp.prev;
            }
        }
        return tmp;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIter();
    }



    public class MyIter implements Iterator<E>{

//        LinkedList<E> data;

        Node<E> first = LinkedList.this.first;

//        public MyIter(LinkedList<E> list){
//            data = list;
//            current = data.first;
//        }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public E next() {
            E tmp = first.elem;
            first = first.next;
            return tmp;
        }
    }


//    @Override
//    public boolean hasNext() {
//        return iterator().hasNext();
//    }
//
//    @Override
//    public E next() {
//        return iterator().next();
//    }

    public static void main(String[] args) {


//        String [] array = {"abc", "xyz"};
//
//
//        Object [] objArr = array;
//
//
//        objArr[0] = 10;
//
//        String foo = array[0];
//
//        System.out.println(foo);

        Integer [] r;

        Integer [] arr = {};

        Number [] nArr = arr;

        Object [] oArr = nArr;



//
//

        List<Integer> list = new LinkedList<>();
//        List<Double> list3 = new LinkedList<>();

//        List<Number> list2 = list;

//        List<Number> list2 = list;
//
//        list.add(20);
//        list.add(10);
//        list.add(5);
//        list.add(9);
//        list.add(0);
//
//        list2.addAll(list);
//
//        list.getAll(list2);
//
    }

    public static void foo3(List<?> list){
        Object o = list.get(0);
        list.add(null);

        list.forEach(System.out::println);
    }

    public static void foo2(List<? super Integer> tt){
        tt.add(10);
        Object i = tt.get(0);
    }

    public static void foo(List<? extends Number> list){
        list.add(null);

        list.remove(0);

        Number n = list.get(0);

        list.forEach(System.out::println);
    }


}

class Foo implements Iterable<String>{

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public String next() {
                return "FOOOO";
            }
        };
    }
}




class Node<E> {
    E elem;
    Node<E> next;
    Node<E> prev;

    Node(E elem) {
        this.elem = elem;
    }
}