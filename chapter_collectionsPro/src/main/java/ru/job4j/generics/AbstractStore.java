package ru.job4j.generics;

/**
 * Class AbstactStore.
 */
public abstract class AbstractStore<T extends Base> {

    private SimpleArray<T> store;
    private int size;


    /**
     * Method to add new element.
     */
    public void add(T model) {
        this.store.add(model);
    }

    /**
     * Method to replace the element.
     */
    public boolean replace(String id, T model) {
        for (int i = 0; i < size; i++) {
            if (id.equals(store.get(i).getId())) {
                store.set(i, model);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to delete the element.
     */
    public boolean delete(String id) {
        for (int i = 0; i < size; i++) {
            if (id.equals(store.get(i).getId())) {
                store.delete(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Method to find element by id.
     */
    public T findById(String id) {

        for (int i = 0; i < size; i++) {
            if (id.equals(store.get(i).getId())) {
                return store.get(i);
            }
        }
        return null;
    }
    public SimpleArray<T> getStore() {
        return store;
    }

    public void setStore(SimpleArray<T> store) {
        this.store = store;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
