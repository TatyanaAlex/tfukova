/**
 * Package for Tracker.
 * @author Tatyana Fukova (mailto: tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10.17
 */
package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TrackerTest.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10
 */
public class TrackerTest {

    /**
     * when user adds the new item the tracker has the same one.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }
    /**
     * check that after changing the name, the item with the same Id has the new name.
     */
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        previous.setId("This is ID number 1");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.update(next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    /**
     * Check that after finding the item by Id and after deletion the tracker doesn't have this item.
     */
    @Test
    public void whenDeleteItemThenArrayWithoutIt() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        item.setId("This is ID number 1");
        tracker.add(item);
        tracker.delete(item);
        Item temp = null;
        assertThat(tracker.findById("This is ID number 1"), is(temp));
    }

    /**
     * Check that after providing the item's name, the item with the set name should be found.
     */
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        item.setId("This is ID number 1");
        tracker.add(item);
        ArrayList<Item> listToFind = new ArrayList<>();
        listToFind.add(item);
        assertThat(tracker.findByName("test1"), is(listToFind));
    }
}
