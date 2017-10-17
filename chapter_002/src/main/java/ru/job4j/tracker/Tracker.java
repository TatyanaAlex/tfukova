
/**
 * Package for Tracker.
 * @author Tatyana Fukova (mailto: tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10.17
 */
 package ru.job4j.tracker;

import java.util.Random;

/**
 * Class Tracker.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10
 */
public class Tracker {

    /**
     * @param items **array of items**.
     */
    private Item[] items = new Item[100];
    /**
     * @param position ** position of the item**.
     */
    private int position = 0;
    /**
     * @param random **for random generations of the items' Id.
     */
    private static final Random RANDOM = new Random();

    /**
     * Method adds new item.
     * @param item **created item**
     * @return item
     */
    public Item add(Item item) {
        item.setId(String.valueOf(RANDOM.nextInt()));
        this.items[position++] = item;
        return item;
    }

    /**
     * Method changes the item.
     * @param itemToUpdate **item that will be changed**
     */
    public void update(Item itemToUpdate) {

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(itemToUpdate.getId())) {
                items[i] = itemToUpdate;
                break;
            }
        }
    }
    /**
     * Method deletes the item.
     * @param itemToDelete **item that will be deleted**
     */
    public void delete(Item itemToDelete) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(itemToDelete.getId())) {
                items[i] = null;
                break;
            }

        }

    }
    /**
     * Method finds all the items.
     * @return final array
     */
    public Item[] findAll() {
        Item[] itemsToCopy = new Item[this.position];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                itemsToCopy[count] = items[i];
                count++;
            }

        }
        Item[] finalArray = new Item[count];
        System.arraycopy(itemsToCopy, 0, finalArray, 0, count);
        return finalArray;
    }

    /**
     * Method finds the item by name.
     * @param key ** the item's name**
     * @return resultArray
     */
    public Item[] findByName(String key) {
        Item[] temp = new Item[this.position];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                temp[count] = items[i];
                count++;
            }

        }

        Item[] resultArray = new Item[count];
        System.arraycopy(temp, 0, resultArray, 0, count);
        return resultArray;

    }

    /**
     * Method finds the item by Id.
     * @param id ** the item's id**
     * @return result
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }

        } return result;

    }

}





