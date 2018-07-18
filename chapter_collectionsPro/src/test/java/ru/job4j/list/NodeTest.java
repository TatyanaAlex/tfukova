package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Test Class.
 */
public class NodeTest {

    /**
     * Test method.
     */
    @Test
    public void whenNodeHasSmallCycle() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(second);

        boolean result = first.hasCycle(first);
        assertThat(result, is(true));
    }

    /**
     * Test method.
     */
    @Test
    public void whenNodeHasNotCycle() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);

        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);

        boolean result = first.hasCycle(first);
        assertThat(result, is(false));
    }
}
