package ru.job4j.modeluser;

import java.util.*;

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
    /**
     * Method to sort the list of users due to the names' length.
     * @param users given list of users.
     * @return sorted list.
     */
    public List<User> sortNameLength(List<User> users) {

        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Integer a = o1.name.length();
                Integer b = o2.name.length();
                return a.compareTo(b);
            }
        });
        return users;
    }
    /**
     * Method to sort the list of users by names and age.
     * @param users given list of users.
     * @return sorted list.
     */
    public List<User> sortByAllFields(List<User> users) {

        Collections.sort(users, new Comparator<User>() {

            public int compare(User o1, User o2) {
                Integer a = o1.name.length();
                Integer b = o2.name.length();
                int comp = a.compareTo(b);
                if (comp != 0) {
                    return comp;
                }
                return o1.age - o2.age;
            }
        });
        return users;
    }
}
