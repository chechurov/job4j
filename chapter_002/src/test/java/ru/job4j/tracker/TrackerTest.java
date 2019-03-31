package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    /**
     * Тест добавления новой заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Тест замены заявки.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тест поиска заявки по id.
     */
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result, is(item));
    }

    /**
     * Тест удаления заявки.
     */
    @Test
    public void whenDeleteById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        Item item3 = new Item("test3", "testDescription3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        Item[] result = tracker.findAll();
        Item[] expected = new Item[] {item1, item3};
        assertThat(result, is(expected));
    }

    /**
     * Тест поиска всех заявок.
     */
    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker.add(item1);
        tracker.add(item2);
        Item[] expected = new Item[] {item1, item2};
        Item[] result = tracker.findAll();
        assertThat(result, is(expected));
    }

    /**
     * Тест поиск по имени заявки.
     */
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        Item item3 = new Item("test1", "testDescription2", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expected = new Item[] {item1, item3};
        Item[] result = tracker.findByName("test1");
        assertThat(result, is(expected));
    }

    /**
     * Тест поиск по имени заявки(заявки не найдены).
     */
    @Test
    public void whenFindByNameThenNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test2", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        Item item3 = new Item("test2", "testDescription2", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.findByName("test1");
        assertThat(result, is(nullValue()));
    }
}