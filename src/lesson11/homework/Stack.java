package lesson11.homework;

/**
 * Created by stefan on 22.08.16.
 */
public interface Stack<T> {

    boolean push(T element);

    T pop();

    T take();

    int size();

    boolean isEmpty();

}
