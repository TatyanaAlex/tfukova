package ru.job4j.list;

/**
 * Class SimpleQueue.
 */
public class SimpleQueue<T> extends NodeList<T> {
    /**
     * method to get the first element and to delete it.
     */

    public T poll() {

        return this.removeFirst();

    }


    /**
     * Method to add the element to queue.
     *
     * @param value
     */

    public void push(T value) {
        this.add(value);
    }

}
