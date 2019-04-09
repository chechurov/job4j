package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Класс, обеспечивающий ввод данных с клавиатуры.
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Вывод на экран вопроса и получение ответа.
     * @param question выводимый на экран вопрос.
     * @return введённый пользователем ответ.
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return this.scanner.nextLine();
    }

    /**
     * Вывод на экран вопроса и получение ответа.
     * @param question выводимый на экран вопрос.
     * @param range массив допустимых ответов.
     * @return введённый пользователем ответ.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}