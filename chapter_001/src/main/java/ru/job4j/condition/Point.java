package ru.job4j.condition;

/**
 * Класс Point.
 */
public class Point {
    /**
     * Вычисление расстояния между двумя точками.
     * @return расстояние.
     */
    public double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow(x2 - x1, 2);
        double second = Math.pow(y2 - y1, 2);
        return Math.sqrt(first + second);
    }
}