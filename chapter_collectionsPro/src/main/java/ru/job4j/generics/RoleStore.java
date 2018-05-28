package ru.job4j.generics;

/**
 * Class RoleStore.
 */
public class RoleStore<Role> extends AbstractStore {

    /**
     * Constructor.
     *
     * @param size - size of the Roles array.
     */
    public RoleStore(int size) {
        this.store = new SimpleArray<Role>(size);
        this.size = size;
    }
}
