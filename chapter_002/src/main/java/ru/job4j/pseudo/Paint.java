package ru.job4j.pseudo;

/**
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Метод рисует фигуру.
     * @param shape фигура.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint p = new Paint();
        System.out.println("Квадрат:");
        p.draw(new Square());
        System.out.println("Треугольник:");
        p.draw(new Triangle());
    }
}