package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class.
 */
public class DynamicListTest {

    /**
     * Test method.
     */
    @Test
    public void whenAddElementShouldAddToArray() {

        DynamicList<String> dynamicList = new DynamicList<String>(5);
        dynamicList.container = new Object[1];

        dynamicList.add("first");
        dynamicList.add("second");

        String result = (String) dynamicList.container[1];

        assertThat(result, is("second"));
    }

    /**
     * Test method.
     */
    @Test
    public void whenSetIndexOfElementShouldReturnElement() {

        DynamicList<String> dynamicList = new DynamicList<String>(3);

        dynamicList.container = new Object[1];

        dynamicList.add("first");
        dynamicList.add("second");

        String result = dynamicList.get(1);

        assertThat(result, is("second"));
    }

    /**
     * Test Method.
     */
    @Test
    public void whenNextShouldreturnNextElement() {
        DynamicList<String> dynamicList = new DynamicList<String>(3);

        dynamicList.container = new Object[1];

        dynamicList.add("first");
        dynamicList.add("second");

        Iterator<String> iterator = dynamicList.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("first"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("second"));

    }


}
