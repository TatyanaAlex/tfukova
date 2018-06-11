package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class DynamicList.
 */
public class DynamicList<E> implements Iterator<E> {

    Object[] container;
    private int index = 0;
    private int cursor = 0;
    protected transient int modCount = 0;
    int expectedModCount = modCount;

    /**
     * Constructor.
     *
     * @param size array´s length.
     */
    public DynamicList(int size) {
        this.container = new Object[size];
    }

    /**
     * Method to add new element.
     */
    public void add(E value) {
        if (index == this.container.length) {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
        }
        this.container[index++] = value;
        modCount++;
    }

    /**
     * Method to get the element.
     */
    public E get(int index) {
        return (E) this.container[index];

    }


    @Override
    public boolean hasNext() {
        return !(this.cursor == this.container.length);
    }

    @Override
    public E next() {
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        cursor++;


        return (E) container[cursor - 1];
    }


}
