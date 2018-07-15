package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Class SimpleStack.
 */
public class SimpleStack<T> {


    private Node<T> node;
    private int size = 0;


    /**
     * Method to get the element.
     */
    public T get(int index) {

        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> result = this.node;

        for (int i = 0; i < index; i++) {

            result = result.next;

        }

        return result.data;

    }


    /**
     * method to get the last element and to delete it.
     *
     * @return currentNode;.
     */
    public T poll() {

        if (this.node == null) {
            throw new NoSuchElementException();
        }
        Node<T> result = this.node;
        Node<T> currentNode = this.node;

        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                result = result.next;
            } else if (i == size - 1) {
                currentNode = result.next;
                result.next = null;
            }

        }

        return (T) currentNode;


    }

    /**
     * Method to add the element to stack.
     *
     * @param value
     */
    public void push(T value) {
        Node<T> newLink = new Node<>(value);
        newLink.next = this.node;
        this.node = newLink;
        this.size++;

    }

    /**
     * Class to store the data.
     */
    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {

            this.data = data;
        }
    }


}
