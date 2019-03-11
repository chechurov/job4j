package ru.job4j.loop;

public class Counter {
    /**
     * Метод подсчитывает сумму четных чисел диапазона
     * @param start начальное число диапазона
     * @param finish конечное число диапазона
     * @return сумма четных чисел
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}