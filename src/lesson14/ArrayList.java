package lesson14;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lesson13.List;
import lesson15.hw.AbstractList;

/**
 * Created by stefan on 08.09.16.
 */

public class ArrayList<T> extends AbstractList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private T [] array;
    private int size;


    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }


    public ArrayList(int capacity)
    {
        this.array = (T[])new Object[capacity];
    }

    public void add(T element)
    {
        if(size() == array.length)
        {
            createNewArray();
        }
        array[size] = element;
        size++;
    }

    private void createNewArray()
    {
        int newLen = array.length * 3 / 2 + 1;
//        System.out.println(newLen);

        array = Arrays.copyOf(array, newLen);
    }

    public void add(int idx, T element)
    {
        if(idx != size) {
            checkIdx(idx);
        }
        if(size() == array.length)
        {
            createNewArray();
        }

        System.arraycopy(array, idx, array, idx + 1, size - idx);
        array[idx] = element;
        size++;
    }

    private void checkIdx(int idx)
    {
        if(idx >= size || idx < 0)
        {
//           System.out.println(idx + " " + size);
            throw new IndexOutOfBoundsException(idx + " " + size);
        }
    }

    public T get(int idx)
    {
        checkIdx(idx);
        return array[idx];
    }

    public T set(int idx, T element)
    {
        checkIdx(idx);
        T value = array[idx];
        array[idx] = element;
        return value;
    }

    public T remove(int idx)
    {
        checkIdx(idx);
        T value = array[idx];
        System.arraycopy(array, idx+1, array, idx, size - idx - 1);
        size--;
        array[size] = null;
        return value;
    }

    private void removeVoid(int idx)
    {
        checkIdx(idx);
        System.arraycopy(array, idx+1, array, idx, size - idx - 1);
        size--;

    }

    public boolean remove(Object o) {
        int idx = indexOf(o);
        if(idx == -1){
            return false;
        }
        removeVoid(idx);
        return true;
//        if(o == null)
//        {
//            for (int i = 0; i < size; i++)
//            {
//                if(array[i] == null) {
//                    removeVoid(i);
//                    return true;
//                }
//            }
//        } else {
//            for (int i = 0; i < size; i++)
//            {
//                if(o.equals(array[i]))
//                {
//                    removeVoid(i);
//                    return true;
//                }
//            }
//        }
//        return false;
    }

    public int indexOf(Object o)
    {
        if(o == null)
        {
            for (int i = 0; i < size; i++)
            {
                if(array[i] == null)
                {

                    return i;
                }
            }
        }

        else {
            for (int i = 0; i < size; i++)
            {
                if(o.equals(array[i]))
                {

                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o)
    {
        if(o == null)
        {
            for (int i = size-1; i >= 0; i--)
            {
                if(array[i] == null)
                {

                    return i;
                }
            }
        }

        else {
            for (int i = size-1; i >= 0; i--)
            {
                if(array[i].equals(o))
                {

                    return i;
                }
            }
        }
        return -1;
    }

    public List<T> subList(int fromIdx, int toIdx)
    {
        checkIdx(fromIdx);
        checkIdx(toIdx);
        T [] copy = (T[])new Object[array.length];
        System.arraycopy(array, fromIdx, copy, 0, size - toIdx);
        return  null;
    }

    public boolean contains(Object o)
    {
        return indexOf(o) >= 0;
    }

    public T reduce(BiFunction<T, T, T> func, T initial)
    {
//        T result = null;
        for (int i = 0; i < size; i++) {
            initial = func.apply(initial, array[i]);
        }
        return initial;
    }

    public void removeIf(Predicate<T> prd) {
        for (int i = 0; i < size; i++) {
            if (prd.test(array[i]))  {
                remove(i);
                i--;
            }
        }
    }

//    public void forEach(Consumer<T> cons) {
//        for(int i = 0; i < size; i++)
//        {
//            cons.accept(array[i]);
//        }
//    }

    @Override
    public <T1> List<T1> map(Function<T, T1> mapper) {
        ArrayList<T1> result = new ArrayList<>(this.size);
        for (int i = 0; i < size; i++){
            result.add(mapper.apply(array[i]));
        }
        return result;
    }

    public void clear()
    {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = null;
        }
    }

    @Override
    public boolean addAll(int idx, List<? extends T> c) {
        return false;
    }


    public int size()
    {
        if(!isEmpty())
        {
            return size;
        }
        return 0;
    }

    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("2");
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("2");
        list.add("2");

        int val = list.map(Integer::parseInt).reduce((o, c) -> o + c, 0);

        System.out.println(val);
//        System.out.println(list.reduce((old, cur) -> old + cur, ""));

//        list.add(1, 10);

        list.remove("Hello");

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}