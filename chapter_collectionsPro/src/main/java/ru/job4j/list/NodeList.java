package ru.job4j.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class NodeList.
 */
public class NodeList<E> implements Iterable<E> {

    private Node<E> node;
    private int size = 0;

    private int modCount = 0;


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

    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int cursor = 0;
            private int expectedModCount = modCount;
            private Node<E> nextNode;

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
                if (cursor == 0) {
                    nextNode = node;
                    cursor++;
                } else {
                    nextNode = node.next;
                    cursor++;
                }

                return nextNode.data;
            }


        };
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



