package ru.job4j.list;


/**
 * Class SimpleArrayList.
 */
public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    /**
     * Method to add data at the beginning of list.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Method to delete the first element of list.
     */
    public E delete() {
        Node<E> result = this.first;
        this.first = result.next;
        this.size--;
        return result.data;
    }

    /**
     * Method to get an element by index.
     */
    public E get(int index) {

        Node<E> result = this.first;

        for (int i = 0; i < index; i++) {

            result = result.next;

        }

        return result.data;

    }

    /**
     * Method to get the size of collection.
     */
    public int getSize() {

        return this.size;

    }

    /**
     * Class to store the data.
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {

            this.data = data;
        }

    }
}
