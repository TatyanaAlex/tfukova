package ru.job4j.list;

public class Node<T> {

    private T value;

    private Node<T> next;


    public Node(T value) {
        this.value = value;
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    boolean hasCycle(Node first) {
        Node slow = first;
        Node fast = first;

        if (first == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }

        }

        return false;

    }
}
