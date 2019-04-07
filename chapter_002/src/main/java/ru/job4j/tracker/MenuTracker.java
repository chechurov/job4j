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
        this.actions[ADD] = new CreateItem();
        this.actions[SHOW] = new ShowAllItems();
        this.actions[EDIT] = new EditItem();
        this.actions[DELETE] = new DeleteItem();
        this.actions[FINDID] = new FindItemById();
        this.actions[FINDNAME] = new FindItemByName();
        this.actions[EXIT] = new ExitProgram();
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

    private class CreateItem implements UserAction {
        @Override
        public int key() {
            return ADD;
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

        @Override
        public String info() {
            return "Добавить новую заявку";
        }
    }

    private class ShowAllItems implements UserAction {
        @Override
        public int key() {
            return SHOW;
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

        @Override
        public String info() {
            return "Показать все заявки";
        }
    }

    private class EditItem implements UserAction {
        @Override
        public int key() {
            return EDIT;
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

        @Override
        public String info() {
            return "Редактировать заявку";
        }
    }

    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return DELETE;
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

        @Override
        public String info() {
            return "Удалить заявку";
        }
    }

    private class FindItemById implements UserAction {
        @Override
        public int key() {
            return FINDID;
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

        @Override
        public String info() {
            return "Найти заявку по id";
        }
    }

    private class FindItemByName implements UserAction {
        @Override
        public int key() {
            return FINDNAME;
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

        @Override
        public String info() {
            return "Найти заявки по наименованию";
        }
    }

    private class ExitProgram implements UserAction {
        @Override
        public int key() {
            return EXIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return "Выйти из программы";
        }
    }
}
