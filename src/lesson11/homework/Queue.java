package lesson11.homework;

/**
 * Created by stefan on 22.08.16.
 */
public interface Queue {
    boolean push(int element);

    Integer pop();

    Integer take();

    int size();

    boolean isEmpty();
}
