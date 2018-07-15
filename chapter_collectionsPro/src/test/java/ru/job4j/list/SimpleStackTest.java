package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class.
 */
public class SimpleStackTest {

    /**
     * Test method.
     */
    @Test
    public void whenPushElementShouldAddIt() {

        SimpleStack<String> simpleStack = new SimpleStack<>();

        simpleStack.push("first");
        simpleStack.push("second");

        String result = simpleStack.get(1);

        assertThat(result, is("first"));
    }

    /**
     * Test method.
     */
    @Test
    public void whenPollElementShouldReturnAndDeleteIt() {

        SimpleStack<String> simpleStack = new SimpleStack<String>();

        simpleStack.push("first");
        simpleStack.push("second");

        String result = null;

        assertThat(simpleStack.poll(), is(result));


    }


}
