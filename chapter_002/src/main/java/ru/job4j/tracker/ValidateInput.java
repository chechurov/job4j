package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int key = -1;
        do {
            try {
                key = super.ask(question, range);
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
