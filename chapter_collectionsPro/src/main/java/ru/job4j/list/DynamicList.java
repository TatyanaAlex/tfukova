package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class DynamicList.
 */
public class DynamicList<E> implements Iterable<E> {

    private Object[] container;
    private int index = 0;

    private int modCount = 0;


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

    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int cursor = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return (this.cursor < container.length);
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
        };

    }


}
