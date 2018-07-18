package ru.job4j.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class NodeList.
 */
public class NodeList<E> implements Iterable<E> {


    private Node<E> head;
    private Node<E> last;


    private int size = 0;

    private int modCount = 0;


    /**
     * Method to add new element at the beginning.
     */
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        //newLink.next = this.node;
        newNode.next = null;
        if (last != null) {
            last.next = newNode;
        } else {
            last = newNode;
        }

        this.size++;
        if (head == null) {
            head = newNode;
        }

        modCount++;
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

    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int cursor = 0;
            private int expectedModCount = modCount;
            private Node<E> nextNode;

            @Override
            public boolean hasNext() {
                return (this.cursor < size);
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
     * Method to remove the first element.
     */
    public E removeFirst() {
        if (head == null) {
            return (E) head;
        }
        Node<E> temp = head;
        head = head.next;
        temp.next = null;
        size--;
        modCount++;

        return (E) temp;

    }

    /**
     * Method to remove the last element.
     */
    public E removeLast() {
        Node<E> last = head;
        Node<E> previousToLast = null;

        while (last.next != null) {
            previousToLast = last;
            last = last.next;
        }
        previousToLast.next = null;

        size--;
        modCount++;

        return (E) last;

    }

    public int getSize() {
        return size;
    }

    /**
     * Class to store the data.
     */
    public static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {

            this.data = data;
        }
    }
}



