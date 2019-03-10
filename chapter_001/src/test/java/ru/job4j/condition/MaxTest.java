package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Max
 */
public class MaxTest {
    /**
     * Второче число больше
     */
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Первое число больше
     */
    @Test
    public void whenMax5To3Then5() {
        Max max = new Max();
        int result = max.max(5, 3);
        assertThat(result, is(5));
    }

    /**
     * Числа равны
     */
    @Test
    public void whenMax6To6Then6() {
        Max max = new Max();
        int result = max.max(6, 6);
        assertThat(result, is(6));
    }
}