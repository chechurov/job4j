package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int key = -1;
        do {
            try {
                key = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Выберите пункт меню из предложенных!");
            } catch (NumberFormatException nfe) {
                System.out.println("Пукнт меню должен быть числовым значением!");
            }
        } while (invalid);
        return key;
    }
}
