package ru.job4j.tracker;

/**
 * Singleton для класс Tracker - Eager loading.
 */
public enum TrackerSingleEnum {
    INSTANCE;

    // Конструкторы и методы.
    public Item add(Item model) {
        return model;
    }
}