package ru.job4j.tracker;

/**
 * Класс эмулирует ответы пользователя.
 */
public class StubInput implements Input {
    private final String[] value;
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Метод возвращает заранее закоготвленный ответ на вопрос.
     * @param question вопрос
     * @return ответ.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
}