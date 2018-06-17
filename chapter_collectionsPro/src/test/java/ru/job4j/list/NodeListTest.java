package ru.job4j.list;


import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class.
 */
public class NodeListTest {

    /**
     * Test method.
     */
    @Test
    public void whenAddElementShouldAddToList() {

        NodeList<String> nodeList = new NodeList<>();

        nodeList.add("first");
        nodeList.add("second");

        String result = nodeList.get(0);

        assertThat(result, is("second"));
    }

    /**
     * Test method.
     */
    @Test
    public void whenHaveIndexOfElementShouldReturnElement() {

        NodeList<String> nodeList = new NodeList<>();

        nodeList.add("first");
        nodeList.add("second");
        String result = nodeList.get(1);

        assertThat(result, is("first"));
    }

    /**
     * Test Method.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void invocationOfNextMethodShouldThrowConcurrentModificationException() {
        NodeList<String> nodeList = new NodeList<>();

        nodeList.add("first");
        nodeList.add("second");
        assertThat(nodeList.hasNext(), is(true));
        assertThat(nodeList.next(), is("second"));
        assertThat(nodeList.hasNext(), is(true));
        assertThat(nodeList.next(), is("first"));
        nodeList.next();
    }


}
