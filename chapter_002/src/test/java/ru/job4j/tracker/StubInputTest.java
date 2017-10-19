package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StubInputTest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();   // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name,desc,5",  "6"}); //создаём StubInput с последовательностью действий
        new StartUi(input, tracker).init();  //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenShowAllThenTrackerFindsAll() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "test name,desc,5", "6"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));

    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", 5));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name,desc,5", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUi(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeletedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 5));
        Input input = new StubInput(new String[]{"3", item.getId(), "test name,desc,5", "6"});
        new StartUi(input, tracker).init();
        Item nullitem = null;
        assertThat(tracker.findById(item.getId()), is(nullitem));
    }
    @Test
    public void whenPutIdThemTrackerFindsById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 5));
        Input input = new StubInput(new String[]{"4", item.getId(), "test name,desc,5", "6"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findAll()[0].getId(), is(item.getId()));
    }
    @Test
    public void whenPutNameThemTrackerFindsByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 5));
        Input input = new StubInput(new String[]{"5", item.getId(), "test name,desc,5", "6"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }


}
