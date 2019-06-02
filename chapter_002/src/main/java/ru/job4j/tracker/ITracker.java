package ru.job4j.tracker;

import java.util.List;

public interface ITracker {
    Item add(Item item);

    void update(Item itemToUpdate);

    void delete(Item itemToDelete);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(String id);
}
