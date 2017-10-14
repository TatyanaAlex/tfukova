package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        previous.setId("This is ID number 1");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.update(next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteItemThenArrayWithoutIt() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        item.setId("This is ID number 1");
        tracker.add(item);
        tracker.delete(item);
        Item temp = null;
        assertThat(tracker.findById("This is ID number 1"), is(temp));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        item.setId("This is ID number 1");
        tracker.add(item);
        Item[] arrayToFind = {item};
        assertThat(tracker.findByName("test1"), is(arrayToFind));
    }


}
