package lesson16;

import lesson14.ArrayList;

import java.util.Comparator;

/**
 * Created by stefan on 13.09.16.
 */
public class TreeSet<E> implements Set<E> {

    private Node<E> root;
    private int size;

    private Comparator<? super E> cmp;

    public TreeSet(){

    }

    public TreeSet(Comparator<? super E> cmp){
        this.cmp = cmp;
    }

    private int compare(E e1, E e2){
        return cmp != null ? cmp.compare(e1, e2) : ((Comparable<E>)e1).compareTo(e2);
    }

    @Override
    public boolean add(E e) {
        if(root == null){
            root = new Node<>(e, null);
            size++;
            return true;
        }



        return add(root, e);
    }

    private boolean add(Node<E> current, E elem){
        int cmp = compare(elem, current.elem);
        if(cmp == 0) return false;

        if(cmp > 0){
            if(current.right != null){
                return add(current.right, elem);
            } else {
                current.right = new Node<>(elem, current);
                return true;
            }
        } else {
            if(current.left != null){
                return add(current.left, elem);
            } else {
                current.left = new Node<>(elem, current);
                return true;
            }
        }
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>((e1, e2) -> e2 - e1);

        for (int i = 0; i < 20; i++){
            int tmp = (int)(Math.random() * 20);
            System.out.print(tmp + " ");
            set.add(tmp);
        }
        System.out.println();
        System.out.println(set);

    }

    private static class Node<T>{
        Node<T> parent;
        Node<T> right;
        Node<T> left;
        T elem;

        public Node(T elem, Node<T> parent) {
            this.elem = elem;
            this.parent = parent;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, root);
        return sb.toString();
    }

    private void toString(StringBuilder sb, Node<E> current){
        if(current.left != null){
            toString(sb, current.left);
        }

        sb.append(current.elem).append(" ");

        if(current.right != null){
            toString(sb, current.right);
        }

    }

}

class Foo{

}