package ru.job4j.calculator;

/**
* Calculator.
* @author Dmitry Chechurov (dima-0794@mail.ru)
*/
public class Calculator {
	/**
	 * Сложение.
	 * @param first first number.
	 * @param second second number.
	 * @return сумма параметров.
	 */
	public double add(double first, double second) {
		return first + second;
	}

	/**
	 * Вычитание.
	 * @param first first number.
	 * @param second second number.
	 * @return Разность параметров.
	 */
	public double subtract(double first, double second) {
		return first - second;
	}

	/**
	 * Умножение.
	 * @param first first number.
	 * @param second second number.
	 * @return Произведение параметров.
	 */
	public double multiple(double first, double second) {
		return first * second;
	}

	/**
	 * Деление.
	 * @param first first number.
	 * @param second second number.
	 * @return частное параметров.
	 */
	public double div(double first, double second) {
		return first / second;
	}
}
	