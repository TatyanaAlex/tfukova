package ru.job4j;

import java.util.HashMap;
import java.util.List;


/**
 * Class UserConvert.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 07.01
 */
public class UserConvert {

    /**
     * Method to convert list to map.
     * @param list given list of users.
     * @return map of users.
     */
    public HashMap<Integer, User> process(List<User> list) {

        HashMap<Integer, User> mapOfUsers = new HashMap<>();

        for (User user : list) {
            mapOfUsers.put(new Integer(user.id), user);
        }

        return mapOfUsers;
    }
}
