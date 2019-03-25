package ru.job4j.array;

public class ArrayInt {
    /**
     * Метод из 2 отсорторитрованных массивов делает один отсортированный.
     * @param array1 первый массив.
     * @param array2 второй массив.
     * @return результирущий массив.
     */
    /*public int[] addTwoArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        for (int i = 0; i != array1.length; i++) {
            result[i] = array1[i];
        }
        for (int i = 0; i != array2.length; i++) {
            result[array1.length + i] = array2[i];
        }
        BubbleSort sort = new BubbleSort();
        return sort.sort(result);
    }*/

    //Второй вариант.
    public int[] addTwoArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, index = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                result[index++] = array1[i++];
            } else {
                result[index++] = array2[j++];
            }
        }
        while (i < array1.length) {
            result[index++] = array1[i++];
        }
        while (j < array2.length) {
            result[index++] = array2[j++];
        }
        return result;
    }
}