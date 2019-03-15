package ru.job4j.array;

public class MatrixCheck {
    /**
     * Метод проверяет, что все элементы по диагоналям равны true или false.
     *
     * @param data массив.
     * @return true, если все элементы по диагоналям равны.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean first = data[0][0];
        for (int i = 0; i != data.length; i++) {
            // Если не квадратная матрица, то выводим сразу false.
            // Иначе проверяем диагональные значения в этой строке.
            if (data.length != data[i].length || data[i][i] != first || data[i][data.length - i - 1] != first) {
                result = false;
                break;
            }
        }
        return result;
    }
}