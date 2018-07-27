package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class.
 */
public class LinkedSetTest {

    /**
     * Test method.
     */
    @Test
    public void whenAddElementShouldAddToLinkedSet() {

        LinkedSet<String> linkedSet = new LinkedSet<>();


        linkedSet.add("first");
        linkedSet.add("second");

        String result = linkedSet.get(1);

        assertThat(result, is("second"));
    }

    /**
     * Test Method.
     */
    @Test
    public void whenNextShouldreturnNextElement() {

        LinkedSet<String> linkedSet = new LinkedSet<>();

        linkedSet.add("first");
        linkedSet.add("first");
        linkedSet.add("second");

        Iterator<String> iterator = linkedSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("first"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("second"));

    }
}
