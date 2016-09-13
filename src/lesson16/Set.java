package lesson16;

/**
 * Created by stefan on 13.09.16.
 */
public interface Set<E> {

    boolean add(E e);

    boolean contains(E e);

    boolean remove(E e);

    int size();
}
