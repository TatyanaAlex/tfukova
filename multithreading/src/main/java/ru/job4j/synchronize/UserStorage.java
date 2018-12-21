package ru.job4j.synchronize;


import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * Class UserStorage.
 */
@ThreadSafe
public class UserStorage {

    private final Map<Integer, User> userStorage = new HashMap<Integer, User>();


    /**
     * method to add users.
     */
    public synchronized boolean add(User user) {
        boolean result = false;
        if (!userStorage.containsKey(user.getId())) {
            userStorage.put(user.getId(), user);
            result = true;
        }
        return result;
    }

    /**
     * method to get users.
     */
    public synchronized User getUser(int id) {
        return this.userStorage.get(id);
    }


    /**
     * method to update users.
     */
    public synchronized boolean update(User user) {
        boolean result = false;
        if (userStorage.containsKey(user.getId())) {
            userStorage.replace(user.getId(), user);
            result = true;
        }
        return result;

    }


    /**
     * method to delete users.
     */
    public synchronized boolean delete(User user) {
        boolean result = false;
        if (userStorage.containsKey(user.getId())) {
            userStorage.remove(user.getId(), user);
            result = true;
        }
        return result;

    }

    /**
     * method to transfer amount.
     */
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        if (userStorage.containsKey(fromId) && userStorage.containsKey(toId)) {
            if (userStorage.get(fromId).getAmount() >= amount) {
                int leftover = userStorage.get(fromId).getAmount() - amount;
                userStorage.get(fromId).setAmount(leftover);
                int total = userStorage.get(toId).getAmount() + amount;
                userStorage.get(toId).setAmount(total);
                result = true;
            }

        }
        return result;

    }


}
