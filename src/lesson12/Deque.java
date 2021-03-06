package lesson12;

import lesson11.homework.Queue;

/**
 * Created by stefan on 01.09.16.
 */

public interface Deque<T> {

    boolean pushFirst(T elem);
    boolean pushLast(T elem);

    T popFirst();
    T popLast();

    T takeFirst();
    T takeLast();

    int size();

    boolean isEmpty();


}
