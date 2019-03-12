package ru.job4j.loop;

/**
 * Класс рисует шахматную доску.
 */
public class Board {
    /**
     *
     * @param width ширина доски.
     * @param height высота доски.
     * @return нарисованная доска.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Если сумма индексов четное число то выводим X, иначе пробел.
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}
