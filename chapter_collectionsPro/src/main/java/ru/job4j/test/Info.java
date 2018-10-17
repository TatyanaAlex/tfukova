package ru.job4j.test;

import java.util.HashMap;
import java.util.List;

public class Info {

    /**
     * Method to count the changes in the collection.
     *
     * @param previous - previous collection.
     * @param current  - new collection.
     * @return map with the counts.
     */
    public HashMap<String, Integer> isDiffer(List<Store.User> previous, List<Store.User> current) {

        int deleteCount = 0;
        int changeCount = 0;
        int initialSize = previous.size();

        HashMap<Integer, String> allUsers = new HashMap<>();

        for (Store.User index : current) {
            allUsers.put(index.getId(), index.getName());
        }
        for (Store.User index : previous) {
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

}
