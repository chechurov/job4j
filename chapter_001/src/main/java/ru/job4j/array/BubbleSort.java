package ru.job4j.array;

public class BubbleSort {
    /**
     * Сортировка массива, используя алгоритм сортировки пузырьком.
     * @param array массив.
     * @return отсортированный массив по возрастанию.
     */
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int k = 0; k <= i - 1; k++) {
                if (array[k] > array [k + 1]) {
                    int temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }
        return array;
    }
}
