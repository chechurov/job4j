package ru.job4j.pseudo;

/**
 * Класс квадрат.
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
    /**
     * Метод рисут квадрат.
     * @return изображение квадрата в виде строки.
     */
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        String ln = System.lineSeparator();
        sb.append("####").append(ln)
                .append("#  #").append(ln)
                .append("#  #").append(ln)
                .append("####");
        return sb.toString();
    }
}