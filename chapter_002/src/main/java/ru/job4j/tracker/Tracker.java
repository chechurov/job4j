package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс используется, как хранилище для заявок.
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка.
     * @return Объект добавленной заявки.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод производит поиск заявки по id.
     * @param id уникальный идентификатор заявки.
     * @return Объект заявки. Если заявка не найдено, то null.
     */
    public Item findById(String id) {
        Item result = null;
        int index = this.findPosById(id);
        if (index != -1) {
            result = this.items[index];
        }
        return result;
    }

    /**
     * Заменяет заявку на заданную.
     * @param id уникальный идентификатор заявки.
     * @param item объект изменённой Заявки.
     * @return true если вставка прошла успешно и false если объект с заданным id не найден.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = this.findPosById(id);
        if (index != -1) {
            item.setId(id);
            this.items[index] = item;
            result = true;
        }
        return result;
    }

    /**
     * Удаляет заявку с заданным id.
     * @param id уникальный идентификатор заявки.
     * @return true если удаление прошло успешно и false если объект с заданным id не найден.
     */
    public boolean delete(String id) {
        boolean result = false;
        int index = this.findPosById(id);
        if (index != -1) {
            System.arraycopy(this.items, index + 1, this.items, index, this.position - index - 1);
            this.items[--this.position] = null;
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает все заявки, кроме пустых.
     * @return массив с заявками. Если заявок нет, то пустой массив.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Возвращает все заявки с заданным именем.
     * @param key заданное имя для поиска.
     * @return массив с заявками. Если заявки не найдены, то пустой массив.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && key.equals(this.items[i].getName())) {
                result[count++] = this.items[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    private int findPosById(String id) {
        int index = -1;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}