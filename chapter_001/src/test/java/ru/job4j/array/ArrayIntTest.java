package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayIntTest {
    @Test
    public void addTwoArrays() {
        ArrayInt a = new ArrayInt();
        int[] input1 = new int[]{1, 4, 5, 7, 9, 12};
        int[] input2 = new int[]{2, 3, 5, 8, 10, 11};
        int[] result = a.addTwoArrays(input1, input2);
        int[] expect = new int[]{1, 2, 3, 4, 5, 5, 7, 8, 9, 10, 11, 12};
        assertThat(result, is(expect));
    }
}