package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray.
 */
public class SimpleArray<T> implements Iterator<T> {

    Object[] objects;
    int index = 0;
    int iteratorIndex = 0;

    /**
     * Constructor.
     *
     * @param size array's size.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Method to add new element.
     */
    public void add(T model) {
        this.objects[index++] = model;

    }

    /**
     * Method to get the element.
     */
    public T get(int index) {
        return (T) this.objects[index];

    }

    /**
     * Method to set the element.
     */
    public void set(int index, T model) {
        this.objects[index] = model;
    }

    /**
     * Method to delete the element.
     */
    public void delete(int index) {
        this.objects[index] = null;
    }

    /**
     * Method to check if there's next element.
     *
     * @return true or false.
     */
    @Override
    public boolean hasNext() {
        return !(this.iteratorIndex == this.objects.length);
    }

    /**
     * Method to return the next element of array.
     *
     * @return array's element.
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) this.objects[iteratorIndex++];
    }
}
