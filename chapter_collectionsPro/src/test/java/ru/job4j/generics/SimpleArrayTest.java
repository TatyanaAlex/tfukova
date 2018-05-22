package ru.job4j.generics;

import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;


/**
 * Test Class.
 */
public class SimpleArrayTest {

    /**
     * Test Method.
     */
    @Test
    public void whenCreateContainerShouldReturnSameType() {
        SimpleArray<String> simple = new SimpleArray<String>(4);
        simple.add("test");
        String result = simple.get(0);
        assertThat(result, is("test"));
    }

    /**
     * Test Method.
     */
    @Test
    public void whenDeleteElementShouldGiveNullValue() {
        SimpleArray<String> simple = new SimpleArray<String>(4);
        simple.add("test");
        simple.add("test 2");

        simple.delete(1);
        String result = simple.get(1);
        assertTrue(result == null);
    }

    /**
     * Test Method.
     */
    @Test
    public void whenGetNextShouldReturnAppropElement() {

        SimpleArray<String> simple = new SimpleArray<String>(4);
        simple.add("test");
        simple.add("test 2");
        assertThat(simple.hasNext(), is(true));
        assertThat(simple.next(), is("test"));
        assertThat(simple.hasNext(), is(true));
        assertThat(simple.next(), is("test 2"));
    }


}
