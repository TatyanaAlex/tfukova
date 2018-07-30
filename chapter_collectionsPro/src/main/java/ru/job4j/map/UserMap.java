package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;


/**
 * Class  UserMap.
 *
 * @author Tatyana Fukova
 * @version $I$
 */
public class UserMap {

    Map<User, Object> map = new HashMap<>();

    /**
     * Method to add to map.
     */
    void add(User user, Object object) {
        map.put(user, object);
    }

    /**
     * Method to show the map.
     */
    void showMap() {
        System.out.println(map);
    }

}
