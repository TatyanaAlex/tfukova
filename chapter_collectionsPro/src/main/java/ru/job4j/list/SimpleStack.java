package ru.job4j.list;


/**
 * Class SimpleStack.
 */

public class SimpleStack<T> extends NodeList<T> {


    /**
     * method to get the last element and to delete it.
     */

    public T poll() {

        return this.removeLast();

    }


    /**
     * Method to add the element to stack.
     *
     * @param value
     */

    public void push(T value) {
        this.add(value);
    }

}





