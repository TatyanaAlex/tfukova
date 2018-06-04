package ru.job4j.generics;

/**
 * Class RoleStore.
 */
public class RoleStore extends AbstractStore<Role> {

    /**
     * Constructor.
     *
     * @param size - size of the Roles array.
     */
    public RoleStore(int size) {

        this.setStore(new SimpleArray<Role>(size));
        this.setSize(size);
    }
}
