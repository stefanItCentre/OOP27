package lesson11;

/**
 * Created by stefan on 06.09.16.
 */

import lesson11.homework.Stack;

/**
 * Created by Denni on 29.08.2016.
 */
public class ArrayStack<V> implements Stack<V> {

    private int maxSize;
    private V [] array;
    private int size;
    private int tail;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array = (V[])new Object[maxSize];
        size = 0;
        tail = 0;
    }


    @Override
    public boolean push(V element) {
        if (tail < maxSize) {
            array[tail++] = element;
            size++;
            return true;
        }
        return false;
    }


    @Override
    public V pop() {
        V res = take();
        tail--;
        size--;
        return res;
    }

    @Override
    public V take() {
        if (!isEmpty()) {
            return array[size - 1];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}