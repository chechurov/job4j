package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Dmitry Chechurov (dima-0794@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class CalculateTest {
 /**
 * Test echo.
 */
	@Test
	 public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Dmitry Chechurov";
		String expect = "Echo, echo, echo : Dmitry Chechurov"; 
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	 }
}