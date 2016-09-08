package lesson13; /**
 * Created by stefan on 06.09.16.
 */

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Рализовать в структурах ArrayList(На основе массива) и LinkedList(Дважды связный список)
 * Допускается и приветствуется обобщенная скелетная реализация в абстрактном классе по усмотрению автора
 * */
public interface List<E> extends Iterable<E> {



    /**
     * Добавляет элемент в конец списка
     * @param element добавляемый элемент
     * */

    void add(E element);

    /**
     * Вставляет элемент в список по указанному индексу
     * @param <b>element</b> добавляемый элемент
     * @param idx индекс по которому происходит вставка
     * @throws IndexOutOfBoundsException если индекс выходит за допустимые границы
     *         (idx &lt; 0 || idx &gt; size())
     */

    void add(int idx, E element);

    /**
     * Возвращает элемент по указанному индексу
     *
     * @param idx индекс возвращаемого элемента
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за допустимые границы
     *         (idx &lt; 0 || idx &gt;= size())
     *
     */

    E get(int idx);

    /**
     * Замещает элемент в списке по указанному индексу новым элементом
     *
     * @param idx индекс замещаемого элемента
     * @param element новый элемент
     * @return элемент который находился по указанному индексу до замещения
     * @throws IndexOutOfBoundsException если индекс выходит за допустимые границы
     *         (idx &lt; 0 || idx &gt;= size())
     */

    E set(int idx, E element);

    /**
     * Удаляет элемент в списке по указанному индексу, возвращает удаленный элемент
     *
     * @param idx индекс удаляемого элемента
     * @return удаленный элемент
     * @throws IndexOutOfBoundsException если индекс выходит за допустимые границы
     *         (idx &lt; 0 || idx &gt;= size())
     */
    E remove(int idx);

    boolean remove(Object o);

    void removeIf(Predicate<E> prd);

//    void forEach(Consumer<E> cons);

    <T> List<T> map(Function<E, T> func);

    E reduce(BiFunction<E, E, E> func, E initial);

    /**
     * Возвращает индекс первого вхождения элемента в списке либо -1 - если такого элемента в списке нет,
     * (Для cравнения использовать метод equals), искомый элемент может быть null
     * @param o искомый элемент, может быть null
     * @return индекс первого вхождения элемента в списке либо -1 - если такого элемента в списке нет
     */

    int indexOf(Object o);

    /**
     * Возвращает индекс последнего вхождения элемента в списке либо -1 - если такого элемента в списке нет,
     * (Для cравнения использовать метод equals), искомый элемент может быть null
     * @param o искомый элемент, может быть null
     * @return индекс первого вхождения элемента в списке либо -1 - если такого элемента в списке нет
     */

    int lastIndexOf(Object o);

    /**
     * Возвращает true, если этот список содержит искомый элемент
     * @param o искомый элемент
     *
     * @return true если этот список содержит искомый элемент
     */

    boolean contains(Object o);

    /**
     * Возвращает список являющийся подсписком данного
     *
     * @param fromIdx нижняя граница, включается в подсписок
     * @param toIdx верхняя граница, не включается в подсписок
     * @return список являющийся подсписком данного
     * @throws IndexOutOfBoundsException при любых некорректных значениях индексов
     *         (fromIdx &lt; 0 || toIdx &gt; size ||
     *         fromIdx &gt; toIdx)
     */

    List<E> subList(int fromIdx, int toIdx);

    /**
     * Удаляет все элементы в списке
     */
    void clear();

    /**
     * Добавляет все элементы в конец этого списка из переданного списка
     *
     * @param list список содержащий добавляемые в этот список элементы
     * @return true если этот список изменился после выполнения операции
     */

    boolean addAll(List<? extends E> list);

    boolean getAll(List<? super E> stock);

    
    /**
     * Вставляет все элементы в этот список из переданного списка по указанному индексу
     *
     * @param list список содержащий добавляемые в этот список элементы
     * @param idx индекс в который происходит вставка
     * @return true если этот список изменился после выполнения операции
     * @throws IndexOutOfBoundsException если индекс выходит за допустимые границы
     *         (idx &lt; 0 || idx &gt;= size())
     */

    boolean addAll(int idx, List<? extends E> c);

    /**
     * Возвращает количество элементов в этом списке
     *
     * @return количество элементов в этом списке
     */
    int size();

    /**
     * Возвращает true если в этом списке нет элементов
     *
     * @return true если в этом списке нет элементов
     */
    boolean isEmpty();

}
