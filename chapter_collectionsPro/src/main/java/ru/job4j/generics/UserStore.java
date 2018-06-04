package ru.job4j.generics;

/**
 * Class UserStore.
 */
public class UserStore extends AbstractStore<User> {
    /**
     * Constructor.
     *
     * @param size - size of the User's array.
     */
    public UserStore(int size) {
        this.setStore(new SimpleArray<User>(size));
        this.setSize(size);
    }

}
