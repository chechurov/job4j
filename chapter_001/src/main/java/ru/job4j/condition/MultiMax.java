package ru.job4j.condition;

public class MultiMax {
    /**
     * Мето выдает максимальное часло.
     *
     * @param first Первое число
     * @param second Второе число
     * @param third Третье число
     * @return Максимальное число
     */
    public int max(int first, int second, int third) {
        // Первый вариант.
        int result = first > second ? first : second;
        return result > third ? result : third;

        //Второй вариант.
        /*return first > second
                            ? first > third
                                            ? first : third
                            : second > third
                                            ? second : third;*/
    }
}