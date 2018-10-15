package ru.job4j.test;

import java.util.HashMap;

import java.util.List;

/**
 * Class Store.
 *
 * @author Tatyana Fukova
 * @version $I$
 */
public class Store {


    /**
     * Method to count the changes in the collection.
     *
     * @param previous - previous collection.
     * @param current  - new collection.
     * @return map with the counts.
     */
    public HashMap<String, Integer> isDiffer(List<User> previous, List<User> current) {

        int deleteCount = 0;
        int changeCount = 0;
        int initialSize = previous.size();

        HashMap<Integer, String> allUsers = new HashMap<>();

        for (User index : current) {
            allUsers.put(index.getId(), index.getName());
        }
        for (User index : previous) {
            if (!allUsers.containsKey(index.getId())) {
                deleteCount++;
            } else if (!allUsers.get(index.getId()).equals(index.getName())) {
                changeCount++;
            }
            allUsers.put(index.getId(), index.getName());
        }

        int newListSize = allUsers.size();
        HashMap<String, Integer> result = new HashMap<>();

        result.put("new added Users: ", newListSize - initialSize);
        result.put("deleted Users: ", deleteCount);
        result.put("changed Users: ", changeCount);

        return result;

    }

    /**
     * Class User.
     */
    static class User {

        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

}
