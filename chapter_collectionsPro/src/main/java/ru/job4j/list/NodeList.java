package ru.job4j.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class NodeList.
 */
public class NodeList<E> implements Iterator<E> {

    private Node<E> node;
    private int size = 0;
    private int cursor = 0;
    private int modCount = 0;
    private int expectedModCount = modCount;

    /**
     * Method to add new element at the beginning.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.node;
        this.node = newLink;
        this.size++;

        modCount++;
    }

    /**
     * Method to get the element.
     */
    public E get(int index) {

        Node<E> result = this.node;

        for (int i = 0; i < index; i++) {

            result = result.next;

        }

        return result.data;

    }


    @Override
    public boolean hasNext() {
        return !(node.next == null);
    }

    @Override
    public E next() {
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.cursor++;


        return (E) node.data;
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



