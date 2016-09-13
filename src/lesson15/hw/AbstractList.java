package lesson15.hw;

import lesson13.List;
import lesson8.Foo;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by stefan on 12.09.16.
 */
public abstract class AbstractList<E> implements List<E> {

    @Override
    public void add(E element) {
        add(size(), element);
    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public void clear() {
        Iterator<E> iter = iterator();
        while(iter.hasNext()){
            iter.next();
            iter.remove();
        }
    }

    @Override
    public int indexOf(Object o) {
        int counter = 0;

        if(o == null){
            for(E e : this){
                if (e == null) {
                    return counter;
                }
                counter++;
            }
        }else {
            for(E e : this){
                if (o.equals(e)) {
                    return counter;
                }
                counter++;
            }
        }
        return -1;
    }

    @Override
    public E reduce(BiFunction<E, E, E> func, E initial) {

        E result = initial;
        for(E e : this){
            result = func.apply(result, e);
        }
        return result;
    }

    @Override
    public boolean addAll(List<? extends E> list) {
        if(list.size() == 0) return false;

        list.forEach(this::add);

        return true;
    }

    @Override
    public boolean getAll(List<? super E> stock) {
        if(size() == 0) return false;
        this.forEach(e -> {
            stock.add(e);
        });
        return true;
    }
}

