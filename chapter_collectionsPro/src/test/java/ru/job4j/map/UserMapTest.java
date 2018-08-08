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

        Calendar calendar = Calendar.getInstance();
        calendar.set(1991, 5, 7, 0, 0, 0);

        User first = new User("Maxim", 1, calendar);
        User second = new User("Maxim", 1, calendar);

        UserMap userMap = new UserMap();

        userMap.add(first, 1);
        userMap.add(second, 2);

        userMap.showMap();

    }
}
