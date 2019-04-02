package ru.job4j.tracker;

/**
 * Класс - пользовательский интерфейс.
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    /**
     * Конструтор, инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.findItemById();
            } else if (FINDNAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void findItemByName() {
        System.out.println("------------ Начало поиска заявки по имени --------------");
        String id = this.input.ask("Введите имя заявки: ");
        Item[] items = this.tracker.findByName(id);
        if (items.length == 0) {
            System.out.println("Не найдено ни одной заявки");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
        System.out.println("------------ Конец поиска заявки по имени --------------");
    }

    private void findItemById() {
        System.out.println("------------ Начало поиска заявки по id --------------");
        String id = this.input.ask("Введите id заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с таким id не найдена!");
        }
        System.out.println("------------ Конец поиска заявки по id --------------");
    }

    private void deleteItem() {
        System.out.println("------------ Начало удаления заявки --------------");
        String id = this.input.ask("Введите id заявки: ");
        boolean result = this.tracker.delete(id);
        if (result) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Заявка не удалена! Проверьте id.");
        }
        System.out.println("------------ Конец удаления заявки --------------");
    }

    private void editItem() {
        System.out.println("------------ Начало редактирования заявки --------------");
        String id = this.input.ask("Введите id заявки: ");
        String name = this.input.ask("Введите новое имя заявки: ");
        String desc = this.input.ask("Введите новое описание заявки: ");
        Item item = new Item(name, desc, System.currentTimeMillis());
        boolean result = this.tracker.replace(id, item);
        if (result) {
            System.out.println("Заявка с Id " + item.getId() + " отредактирована");
        } else {
            System.out.println("Заявка не отредактирована! Проверьте id.");
        }
        System.out.println("------------ Конец редактирования заявки --------------");
    }

    private void showAllItems() {
        System.out.println("------------ Начало вывода всех заявок --------------");
        Item[] items = this.tracker.findAll();
        if (items.length == 0) {
            System.out.println("Не найдено ни одной заявки");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
        System.out.println("------------ Конец вывода всех заявок --------------");
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId: " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("0. Добавить новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по id");
        System.out.println("5. Найти заявки по наименованию");
        System.out.println("6. Выйти из программы");
    }

    /**
     * Запускт программы.
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}