package ru.job4j.tracker;

public interface UserAction {
    /**
     * Метод возвращает номер меню.
     * @return номер.
     */
    int key();

    /**
     * Метод выполняет действие.
     * @param input объект типа Input.
     * @param tracker объект типа Tracker.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню.
     */
    String info();
}