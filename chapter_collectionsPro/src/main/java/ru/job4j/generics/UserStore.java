package ru.job4j.generics;

/**
 * Class UserStore.
 */
public class UserStore<User> extends AbstractStore {
    /**
     * Constructor.
     *
     * @param size - size of the User's array.
     */
    public UserStore(int size) {
        this.store = new SimpleArray<User>(size);
        this.size = size;
    }

}
