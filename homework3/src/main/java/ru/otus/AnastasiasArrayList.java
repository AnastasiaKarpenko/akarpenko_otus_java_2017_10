package ru.otus;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by anastasia on 02/11/2017.
 * Написать свою реализацию ArrayList на основе массива.

 class MyArrayList<T> implements List<T>{...}

 Проверить, что на ней работают методы
 addAll(Collection<? super T> c, T... elements)
 static <T> void    copy(List<? super T> dest, List<? extends T> src)
 static <T> void    sort(List<T> list, Comparator<? super T> c)

 из java.util.Collections
 */

public class AnastasiasArrayList<T> implements List<T> {
    private Object[] data;
    private int dataLength;
    private int containerLength;

    AnastasiasArrayList() {
        this(20);
    }

    AnastasiasArrayList(int size) {
        data = new Object[size];
        dataLength = 0;
        containerLength = size;
    }

    public int size() {
        return dataLength;
    }

    public boolean isEmpty() {
        return dataLength == 0;
    }

    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    public Iterator iterator() {
        return new AnastasiasIterator(data);
    }

    public Object[] toArray() {
        Object[] array = new Object[dataLength];

        for(int i = 0; i < dataLength; i++) {
            array[i] = data[i];
        }

        return array;
    }

    public <Tt> Tt [] toArray(Tt[] tts) {
        Object[] array = new Object[dataLength];

        for (int i = 0; i < dataLength; i++) {
            array[i] = data[i];
        }

        return (Tt[]) array;
    }

    public boolean add(T t) {
        add(dataLength, t);
        return true;
    }

    public boolean remove(Object o) {
        int i;
        if ((i = indexOf((T) o)) >= 0) {
            remove(i);
            return true;
        } else
            return false;
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        data = new Object[21];
        dataLength = 0;
        containerLength = 20;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public T set(int index, T element) {
        checkLength(index);

        T returned = (T) data[index];
        data[index] = element;

        return returned;
    }

    public void add(int index, T element) {
        checkLength(index);

        checkIfIsEnding();

        for (int i = dataLength; i >= index; i--) {
            data[i + 1] = data[i];

            if (i == index) {
                data[i] = element;
            }
        }

        dataLength++;

    }

    public T remove(int index) {
        checkLength(index);

        T t = (T) data[index];

        for (int i = index; i < dataLength; i++) {
            data[i] = data[i + 1];
        }

        if(t != null) {
            dataLength--;
        }
        return t;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < dataLength; i++) {
            if (o.equals(data[i])) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<T> listIterator() {
        return new AnastasiasIterator<>(data);
    }

    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private void checkIfIsEnding() {
        if ((dataLength + 1) == containerLength) {
            increaseList(containerLength * 2);
        }
    }

    private void checkLength(int index) {
        if (index < 0 || index > dataLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    private void increaseList(int newSize) {
        if (newSize < containerLength) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Object[] newArr = new Object[newSize];
        for (int i = 0; i < containerLength; i++) {
            if (i < dataLength + 1) {
                newArr[i] = data[i];
            } else {
                newArr[i] = null;
            }
        }
        data = newArr;
        containerLength = newSize;
    }


    class AnastasiasIterator<T> implements ListIterator<T> {

        Object[] data;
        int pointer = 0;

        AnastasiasIterator(Object[] data) {
            this.data = data;
        }

        public boolean hasNext() {
            return pointer <= dataLength;
        }

        public T next() {
            pointer++;
            return (T) data[pointer - 1];
        }

        public boolean hasPrevious() {
            throw new UnsupportedOperationException();
        }

        public T previous() {
            throw new UnsupportedOperationException();
        }

        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        public void remove() {

        }

        public void set(T t) {
            data[pointer - 1] = t;
        }

        public void add(T t) {
            throw new UnsupportedOperationException();
        }
    }
}
