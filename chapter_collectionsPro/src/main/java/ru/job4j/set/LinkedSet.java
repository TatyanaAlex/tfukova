package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class  LinkedSet.
 *
 * @author Tatyana Fukova
 * @version $I$
 */
public class LinkedSet<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> last;

    private int size = 0;


    /**
     * Method to add new element.
     */
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (duplicate(data)) {

            newNode.next = null;
            if (head == null) {
                head = newNode;
            }
            if (last == null) {
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }

            this.size++;
        }

    }

    /**
     * Method to check the duplicated elements.
     */
    private boolean duplicate(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(get(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * Method to get the element.
     */
    public E get(int index) {

        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> result = this.head;

        for (int i = 0; i < index; i++) {

            result = result.next;

        }

        return result.data;

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int cursor = 0;

            private Node<E> nextNode;

            @Override
            public boolean hasNext() {
                return (this.cursor < size);
            }

            @Override
            public E next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (cursor == 0) {
                    nextNode = head;
                    cursor++;
                } else {
                    nextNode = nextNode.next;
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
