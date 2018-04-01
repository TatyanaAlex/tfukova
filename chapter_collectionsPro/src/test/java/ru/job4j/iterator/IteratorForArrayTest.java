package ru.job4j.iterator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test Class.
 */
public class IteratorForArrayTest {

    /**
     * Test Method.
     */
    @Test
    public void whenGetNextShouldReturnAppropElement() {

        IteratorForArray it = new IteratorForArray(new int[][] {{1, 2}, {3, 4}});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }
}