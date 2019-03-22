package ru.job4j.array;

public class ArrayInt {
    /**
     * Метод из 2 отсорторитрованных массивов делает один отсортированный.
     * @param array1 первый массив.
     * @param array2 второй массив.
     * @return результирущий массив.
     */
    public int[] addTwoArrays(int[] array1, int[] array2) {
        int[] resultArray = new int[array1.length + array2.length];
        for (int i = 0, j = 0; i != array1.length; i++, j += 2) {
            if (array1[i] >= array2[i]) {
                resultArray[j] = array2[i];
                resultArray[j + 1] = array1[i];
            } else {
                resultArray[j + 1] = array2[i];
                resultArray[j] = array1[i];
            }
        }
        return resultArray;
    }
}
