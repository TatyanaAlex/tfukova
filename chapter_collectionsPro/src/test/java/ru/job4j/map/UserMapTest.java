package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;

/**
 * Class  UserMapTest.
 *
 * @author Tatyana Fukova
 * @version $I$
 */
public class UserMapTest {

    /**
     * Test Method.
     */
    @Test
    public void whenAddShouldShowTheMap() {

        User first = new User("Maxim", 1, Calendar.getInstance());
        User second = new User("Maxim", 1, Calendar.getInstance());

        UserMap userMap = new UserMap();

        userMap.add(first, 1);
        userMap.add(second, 2);

        userMap.showMap();

    }
}
