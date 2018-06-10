package ru.job4j.list;

import org.junit.Test;

import org.junit.Before;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertThat;


/**
 * Test Class.
 */
public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before

    public void beforeTest() {

        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

    }


    /**
     * Test Method.
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {

        assertThat(list.get(1), is(2));

    }


    /**
     * Test Method.
     */
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {

        assertThat(list.getSize(), is(3));
    }

    /**
     * Test Method.
     */
    @Test
    public void whenDeleteFirstElementSizeLess() {

        list.delete();
        assertThat(list.getSize(), is(2));
    }

}

