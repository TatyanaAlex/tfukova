package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class.
 */
public class SimpleQueueTest {
    /**
     * Test method.
     */
    @Test
    public void whenPushElementShouldAddIt() {

        SimpleQueue<String> simpleQueue = new SimpleQueue<>();

        simpleQueue.push("first");
        simpleQueue.push("second");

        String result = simpleQueue.get(1);

        assertThat(result, is("second"));
    }

    /**
     * Test method.
     */
    @Test
    public void whenPollElementShouldReturnAndDeleteIt() {

        SimpleQueue<String> simpleQueue = new SimpleQueue<>();

        simpleQueue.push("first");
        simpleQueue.push("second");


        simpleQueue.poll();
        String result = simpleQueue.get(0);

        assertThat(result, is("second"));
        assertThat(1, is(simpleQueue.getSize()));


    }

}
