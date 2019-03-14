package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет, что слово начинается с префикса.
     * @param prefix префикс.
     * @return true, если слово начинается с префикса.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        if (value.length > data.length) {
            return false;
        }
        // проверить, что массив data имеет первые элементы, одинаковые с value
        for (int i = 0; i != value.length; i++) {
            if (value[i] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}