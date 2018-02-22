
/**
 * Package for Tracker.
 * @author Tatyana Fukova (mailto: tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10.17
 */
 package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class Tracker.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10
 */
public class Tracker {

    /**
     * @param items **list of items**.
     */
    private ArrayList<Item> items = new ArrayList<>();
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
        this.items.add(item);
        return item;
    }

    /**
     * Method changes the item.
     * @param itemToUpdate **item that will be changed**
     */
    public void update(Item itemToUpdate) {

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(itemToUpdate.getId())) {
                items.remove(i);
                items.add(i, itemToUpdate);
                break;
            }
        }
    }
    /**
     * Method deletes the item.
     * @param itemToDelete **item that will be deleted**
     */
    public void delete(Item itemToDelete) {
        this.items.remove(itemToDelete);

    }
    /**
     * Method finds all the items.
     * @return final list
     */
    public ArrayList<Item> findAll() {
        this.items.trimToSize();
        return this.items;
    }

    /**
     * Method finds the item by name.
     * @param key ** the item's name**
     * @return finalList
     */
    public ArrayList<Item> findByName(String key) {
       ArrayList<Item> finalList = new ArrayList<>();
       for (Item item : this.items) {
           if (item.getName().equals(key)) {
               finalList.add(item);
           }
       }
       finalList.trimToSize();

        return finalList;
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





