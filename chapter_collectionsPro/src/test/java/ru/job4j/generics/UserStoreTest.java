package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * Test Class.
 */
public class UserStoreTest {

    /**
     * Test Method.
     */
    @Test
    public void whenAddShouldContains() {
        UserStore<User> users = new UserStore<>(7);
        User user1 = new User("235");
        users.add(user1);
        User result = (User) users.store.get(0);
        assertThat(result, is(user1));
    }

    /**
     * Test Method.
     */
    @Test
    public void whenGiveUserShouldDeleteIt() {
        UserStore<User> users = new UserStore<>(7);
        User user1 = new User("235");
        User user2 = new User("1795");

        users.add(user1);
        users.add(user2);

        users.delete("1795");
        User result = (User) users.store.get(1);
        assertTrue(result == null);
    }

    /**
     * Test Method.
     */
    @Test
    public void whenGiveUserShouldUpdate() {
        UserStore<User> users = new UserStore<>(7);
        User user1 = new User("235");
        User user2 = new User("1795");
        User user3 = new User("077");

        users.add(user1);
        users.add(user2);

        users.replace("235", user3);
        User result = (User) users.store.get(0);

        assertThat(result.getId(), is("077"));
    }

}
