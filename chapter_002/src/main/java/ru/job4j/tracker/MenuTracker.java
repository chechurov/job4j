package ru.job4j.tracker;

public class MenuTracker {
    private static final int ADD = 0;
    private static final int SHOW = 1;
    private static final int EDIT = 2;
    private static final int DELETE = 3;
    private static final int FINDID = 4;
    private static final int FINDNAME = 5;
    private static final int EXIT = 6;
    private final Tracker tracker;
    private final Input input;
    private final UserAction[] actions = new UserAction[7];
    private int position;

    /**
     * Конструтор, инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions[this.position++] = new CreateItem(ADD, "Добавить новую заявку");
        this.actions[this.position++] = new ShowAllItems(SHOW, "Показать все заявки");
        this.actions[this.position++] = new EditItem(EDIT, "Редактировать заявку");
        this.actions[this.position++] = new DeleteItem(DELETE, "Удалить заявку");
        this.actions[this.position++] = new FindItemById(FINDID, "Найти заявку по id");
        this.actions[this.position++] = new FindItemByName(FINDNAME, "Найти заявки по наименованию");
        this.actions[this.position++] = new ExitProgram(EXIT, "Выйти из программы");
    }

    /**
     * Метод для получения массива меню.
     * @return длину массива.
     */
    public int getActionsLength() {
        return this.actions.length;
    }

    /**
     * Метод выполняет действие под указанным номером.
     * @param key номер меню.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        System.out.println("Меню:");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(String.format("%s. %s", action.key(), action.info()));
            }
        }
    }

    /**
     * Метод возвращает номер выхода из меню.
     * @return номер выхода из меню.
     */
    public int getExit() {
        return EXIT;
    }

    private class CreateItem extends BaseAction {
        public CreateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId: " + item.getId() + "-----------");
        }
    }

    private class ShowAllItems extends BaseAction {
        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Начало вывода всех заявок --------------");
            Item[] items = tracker.findAll();
            if (items.length == 0) {
                System.out.println("Не найдено ни одной заявки");
            } else {
                for (Item item : items) {
                    System.out.println(item);
                }
            }
            System.out.println("------------ Конец вывода всех заявок --------------");
        }
    }

    private class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Начало редактирования заявки --------------");
            String id = input.ask("Введите id заявки: ");
            String name = input.ask("Введите новое имя заявки: ");
            String desc = input.ask("Введите новое описание заявки: ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            boolean result = tracker.replace(id, item);
            if (result) {
                System.out.println("Заявка с Id " + item.getId() + " отредактирована");
            } else {
                System.out.println("Заявка не отредактирована! Проверьте id.");
            }
            System.out.println("------------ Конец редактирования заявки --------------");
        }
    }

    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Начало удаления заявки --------------");
            String id = input.ask("Введите id заявки: ");
            boolean result = tracker.delete(id);
            if (result) {
                System.out.println("Заявка удалена");
            } else {
                System.out.println("Заявка не удалена! Проверьте id.");
            }
            System.out.println("------------ Конец удаления заявки --------------");
        }
    }

    private class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Начало поиска заявки по id --------------");
            String id = input.ask("Введите id заявки: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("Заявка с таким id не найдена!");
            }
            System.out.println("------------ Конец поиска заявки по id --------------");
        }
    }

    private class FindItemByName extends BaseAction {
        public FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Начало поиска заявки по имени --------------");
            String id = input.ask("Введите имя заявки: ");
            Item[] items = tracker.findByName(id);
            if (items.length == 0) {
                System.out.println("Не найдено ни одной заявки");
            } else {
                for (Item item : items) {
                    System.out.println(item);
                }
            }
            System.out.println("------------ Конец поиска заявки по имени --------------");
        }
    }

    private class ExitProgram extends BaseAction {
        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }
}
