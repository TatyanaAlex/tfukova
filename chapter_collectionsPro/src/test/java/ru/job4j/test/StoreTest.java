package ru.job4j.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class StoreTest.
 *
 * @author Tatyana Fukova
 * @version $I$
 */
public class StoreTest {

    Store store = new Store();
    List<Store.User> oldUsers = new LinkedList<>();
    List<Store.User> newUsers = new LinkedList<>();

    @Before
    public void addElementInCollections() {
        oldUsers.add(new Store.User(1, "Alex"));
        oldUsers.add(new Store.User(2, "Victoria"));
        oldUsers.add(new Store.User(3, "Max"));

    }


    /**
     * Test method.
     */
    @Test
    public void whenCollectionsAreSame() {
        newUsers.add(new Store.User(1, "Alex"));
        newUsers.add(new Store.User(2, "Victoria"));
        newUsers.add(new Store.User(3, "Max"));

        HashMap result = store.isDiffer(oldUsers, newUsers);
        assertThat(result.get("new added Users: "), is(0));
        assertThat(result.get("deleted Users: "), is(0));
        assertThat(result.get("changed Users: "), is(0));
    }

    /**
     * Test method.
     */
    @Test
    public void whenCollectionIsChanged() {
        newUsers.add(new Store.User(1, "Vladimir"));
        newUsers.add(new Store.User(3, "Eva"));
        newUsers.add(new Store.User(4, "Anton"));
        newUsers.add(new Store.User(5, "Anna"));
        HashMap result = store.isDiffer(oldUsers, newUsers);
        assertThat(result.get("new added Users: "), is(2));
        assertThat(result.get("deleted Users: "), is(1));
        assertThat(result.get("changed Users: "), is(2));
    }


}
