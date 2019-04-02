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
    public String ask(String question) {
        System.out.print(question);
        return this.scanner.nextLine();
    }
}