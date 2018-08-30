package ru.job4j.map;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class  MyHashMapTest.
 *
 * @author Tatyana Fukova
 * @version $I$
 */
public class MyHashMapTest {

    /**
     * Test method.
     */
    @Test
    public void whenGiveKeyAndValueShouldInsertToMap() {

        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        myHashMap.insert("key1", 1);
        myHashMap.insert("key2", 2);

        Integer result = myHashMap.get("key2");
        assertThat(result, is(2));
    }

    /**
     * Test method.
     */
    @Test
    public void whenDeleteShouldDecreaseMap() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        myHashMap.insert("key1", 1);
        Boolean result = myHashMap.delete("key1");
        assertThat(result, is(true));
    }

    /**
     * Test method.
     */
    @Test
    public void whenHasElementShouldReturnTrue() {

        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        myHashMap.insert("key1", 1);
        myHashMap.insert("key2", 2);

        myHashMap.iterator().next();
        assertTrue(myHashMap.iterator().hasNext());

    }


}
