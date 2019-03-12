package ru.job4j.loop;

public class Factorial {
    /**
     * Метод вычисляет факториал.
     * @param n число.
     * @return факториал числа.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}