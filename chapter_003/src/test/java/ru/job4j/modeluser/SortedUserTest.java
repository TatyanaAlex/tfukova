package ru.job4j.modeluser;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SortedUserTest.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 18.01
 */
public class SortedUserTest {

    /**
     * Method to check if the list of users is sorted.
     * @return set of users.
     */
    @Test
    public void whenGiveListOfUsersShouldReturnTreeSet() {
        SortedUser sortedUser = new SortedUser();

        User user1 = new User("Ivan", 43);
        User user2 = new User("Maxim", 25);
        User user3 = new User("Alexander", 33);

        Set<User> resultUsers = new TreeSet<>();
        resultUsers = sortedUser.sort(Arrays.asList(user1, user2, user3));

        ArrayList<User> listUsers = new ArrayList<>();
        for (User user : resultUsers) {
            listUsers.add(user);
        }
        assertThat(listUsers.get(0), is(user2));
        assertThat(listUsers.get(1), is(user3));
        assertThat(listUsers.get(2), is(user1));

    }
    /**
     * Test method.
     * @return list of users sorted by the names' length.
     */
    @Test
    public void whenGiveListShouldSortByNameLength() {
        SortedUser sortedUser = new SortedUser();
        User user1 = new User("Ivan", 43);
        User user2 = new User("Maxim", 25);
        User user3 = new User("Alexander", 33);

        List<User> resultUsers = new ArrayList<>();
        resultUsers = sortedUser.sortNameLength(Arrays.asList(user1, user2, user3));

        assertThat(resultUsers.get(0), is(user1));
        assertThat(resultUsers.get(1), is(user2));
        assertThat(resultUsers.get(2), is(user3));

    }
    /**
     * Test method.
     * @return list of users sorted by the names' length and age.
     */
    @Test
    public void whenGiveListShouldSortByNameLengthAndAge() {
        SortedUser sortedUser = new SortedUser();
        User user1 = new User("Anton", 43);
        User user2 = new User("Maxim", 25);
        User user3 = new User("Alexander", 33);

        List<User> resultUsers = new ArrayList<>();
        resultUsers = sortedUser.sortByAllFields(Arrays.asList(user1, user2, user3));

        assertThat(resultUsers.get(0), is(user2));
        assertThat(resultUsers.get(1), is(user1));
        assertThat(resultUsers.get(2), is(user3));

    }


}
