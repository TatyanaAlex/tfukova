package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class.
 */
public class SimpleSetTest {
    /**
     * Test method.
     */
    @Test
    public void whenAddElementShouldAddToArray() {

        SimpleSet<String> simpleSet = new SimpleSet<>(3);


        simpleSet.add("first");
        simpleSet.add("second");

        String result = simpleSet.get(1);

        assertThat(result, is("second"));
    }

    /**
     * Test Method.
     */
    @Test
    public void whenNextShouldreturnNextElement() {

        SimpleSet<String> simpleSet = new SimpleSet<>(3);

        simpleSet.add("first");
        simpleSet.add("first");
        simpleSet.add("second");

        Iterator<String> iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("first"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("second"));

    }
}
