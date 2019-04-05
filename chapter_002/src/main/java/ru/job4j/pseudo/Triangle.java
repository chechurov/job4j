package ru.job4j.pseudo;

/**
 * Класс треугольник.
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {

    /**
     * Метод рисует треугольник.
     * @return изображение треугольника в виде строки.
     */
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        String ln = System.lineSeparator();
        sb.append("   #").append(ln)
                .append("  # #").append(ln)
                .append(" #   #").append(ln)
                .append("#######");
        return sb.toString();
    }
}