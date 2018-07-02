package ru.job4j.list;


import org.junit.Test;


import java.util.Iterator;

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
    @Test
    public void whenNextShouldreturnNextElement() {
        NodeList<String> nodeList = new NodeList<>();

        nodeList.add("first");
        nodeList.add("second");

        Iterator<String> iterator = nodeList.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("second"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("first"));

    }


}
