package ru.job4j.modeluser;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class SortedUser.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 18.01
 */
public class SortedUser implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        int res = o1.name.compareTo(o2.name);
        if (res != 0) {
            res = Integer.compare(o1.age, o2.age);
        }
        return res;
    }

    /**
     * Method to sort the list of users and return TreeSet.
     * @param users given list of users.
     * @return TreeSet of users.
     */
    public Set<User> sort(List<User> users) {
        Set<User> sortedUsers = new TreeSet<>();
        sortedUsers.addAll(users);
        return sortedUsers;
    }
}
