package ru.job4j.tracker;

/**
 * Singleton для класс Tracker - Eager loading.
 */
public class TrackerSingleStaticFinalField {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleStaticFinalField() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }
}