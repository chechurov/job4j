package ru.job4j.condition;

/**
 * Класс Max.
 */
public class Max {
    /**
     * Вычисление максимального значения.
     * @param left первое значение.
     * @param right второе значение.
     * @return наибольшее значение из двух.
     */
    public int max(int left, int right) {
        return left > right ? left : right;
    }
}
