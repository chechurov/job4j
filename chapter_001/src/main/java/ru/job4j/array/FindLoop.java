package ru.job4j.array;

public class FindLoop {
    /**
     * Поиск элемента в массиве.
     * @param data массив.
     * @param el значение.
     * @return индекс найденного значения в массиве.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = 0; i != data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}