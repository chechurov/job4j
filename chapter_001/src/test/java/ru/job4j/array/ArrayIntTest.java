package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayIntTest {
    @Test
    public void whenArraysLengthIsEqual() {
        ArrayInt a = new ArrayInt();
        int[] input1 = new int[] {1, 4, 5, 7, 9, 12};
        int[] input2 = new int[] {2, 3, 5, 8, 10, 11};
        int[] result = a.addTwoArrays(input1, input2);
        int[] expect = new int[] {1, 2, 3, 4, 5, 5, 7, 8, 9, 10, 11, 12};
        assertThat(result, is(expect));
    }
    @Test
    public void whenFirstArrayLarger() {
        ArrayInt a = new ArrayInt();
        int[] input1 = new int[] {1, 3, 5, 7, 9};
        int[] input2 = new int[] {2, 6, 10};
        int[] result = a.addTwoArrays(input1, input2);
        int[] expect = new int[] {1, 2, 3, 5, 6, 7, 9, 10};
        assertThat(result, is(expect));
    }
    @Test
    public void whenSecondArrayLarger() {
        ArrayInt a = new ArrayInt();
        int[] input1 = new int[] {3, 4, 5};
        int[] input2 = new int[] {1, 3, 7, 12, 13};
        int[] result = a.addTwoArrays(input1, input2);
        int[] expect = new int[] {1, 3, 3, 4, 5, 7, 12, 13};
        assertThat(result, is(expect));
    }
    @Test
    public void whenArraysLengthIsNull() {
        ArrayInt a = new ArrayInt();
        int[] input1 = new int[0];
        int[] input2 = new int[0];
        int[] result = a.addTwoArrays(input1, input2);
        int[] expect = new int[0];
        assertThat(result, is(expect));
    }
    @Test
    public void whenFirstArrayLengthIsNull() {
        ArrayInt a = new ArrayInt();
        int[] input1 = new int[0];
        int[] input2 = new int[] {1, 3, 5, 7};
        int[] result = a.addTwoArrays(input1, input2);
        int[] expect = new int[] {1, 3, 5, 7};
        assertThat(result, is(expect));
    }
}