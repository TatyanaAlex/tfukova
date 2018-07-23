package ru.job4j.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class  SimpleSet.
 *
 * @author Tatyana Fukova
 * @version $I$
 */
public class SimpleSet<E> implements Iterable<E> {


    private Object[] container;
    private int index = 0;

    /**
     * Constructor.
     *
     * @param size array´s length.
     */
    public SimpleSet(int size) {
        this.container = new Object[size];
    }

    /**
     * Method to add new element.
     */
    public void add(E value) {

        for (int i = 0; i < this.index; i++) {
            if (this.container[i].equals(value)) {
                return;
            }
        }
        if (index == this.container.length) {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
        }
        this.container[index++] = value;

    }

    /**
     * Method to get the element.
     */
    public E get(int index) {
        return (E) this.container[index];

    }


    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int cursor = 0;


            @Override
            public boolean hasNext() {
                return (this.cursor < container.length);
            }

            @Override
            public E next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                cursor++;


                return (E) container[cursor - 1];
            }
        };

    }
}
