package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final String ln = System.lineSeparator();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Тест добавления заявки.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Тест редактирования заявки.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Тест удаления заявки.
     */
    @Test
    public void whenDeleteThenTrackerHasNotFindValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        Item expected = null;
        assertThat(tracker.findById(item.getId()), is(expected));
    }

    /**
     * Тест вывода всех заявок.
     */
    @Test
    public void whenShowAll() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name2", "desc1", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("name2", "desc2", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        StringBuilder expected = new StringBuilder()
                .append(getMenu())
                .append("------------ Начало вывода всех заявок --------------").append(this.ln)
                .append(item1.toString()).append(this.ln)
                .append(item2.toString()).append(this.ln)
                .append("------------ Конец вывода всех заявок --------------").append(this.ln)
                .append(getMenu());
        assertThat(new String(out.toByteArray()), is(expected.toString())
        );
    }

    /**
     * Тест вывода заявки по id.
     */
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        StringBuilder expected = new StringBuilder()
                .append(getMenu())
                .append("------------ Начало поиска заявки по id --------------").append(this.ln)
                .append(item1.toString()).append(this.ln)
                .append("------------ Конец поиска заявки по id --------------").append(this.ln)
                .append(getMenu());
        assertThat(new String(out.toByteArray()), is(expected.toString())
        );
    }

    /**
     * Тест вывода заявки по name.
     */
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", item1.getName(), "6"});
        new StartUI(input, tracker).init();
        StringBuilder expected = new StringBuilder()
                .append(getMenu())
                .append("------------ Начало поиска заявки по имени --------------").append(this.ln)
                .append(item1.toString()).append(this.ln)
                .append("------------ Конец поиска заявки по имени --------------").append(this.ln)
                .append(getMenu());
        assertThat(new String(out.toByteArray()), is(expected.toString())
        );
    }

    private String getMenu() {
        return new StringBuilder()
                .append("Меню:").append(this.ln)
                .append("0. Добавить новую заявку").append(this.ln)
                .append("1. Показать все заявки").append(this.ln)
                .append("2. Редактировать заявку").append(this.ln)
                .append("3. Удалить заявку").append(this.ln)
                .append("4. Найти заявку по id").append(this.ln)
                .append("5. Найти заявки по наименованию").append(this.ln)
                .append("6. Выйти из программы").append(this.ln)
                .toString();
    }
}
