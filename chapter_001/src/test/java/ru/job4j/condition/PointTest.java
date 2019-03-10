package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test Point.
 */
public class PointTest {
    /**
     * Test distance.
     */
    @Test
    public void whenZeroAndTenThenTen() {
        Point point = new Point();
        double result = point.distance(3, 0, 0, 4);
        assertThat(result, is(5D));
    }
}