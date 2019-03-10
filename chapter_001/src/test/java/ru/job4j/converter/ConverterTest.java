package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * test Converter
 */
public class ConverterTest {
    /**
     * test rubleToDollar
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }
    /**
     * test rubleToEuro
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }
    /**
     * test euroToRuble(
     */
    @Test
    public void when2EuroToRubleThen140() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(2);
        assertThat(result, is(140));
    }
    /**
     * test dollarToRuble
     */
    @Test
    public void when3DollarToRubleThen180() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(3);
        assertThat(result, is(180));
    }
}