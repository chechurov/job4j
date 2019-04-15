package ru.job4j.tracker;

/**
 * Singleton для класс Tracker - Lazy loading.
 */
public class TrackerSingleStaticFinalClass {

    private TrackerSingleStaticFinalClass() {
    }

    public static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }
}