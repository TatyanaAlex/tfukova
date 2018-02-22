package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
* @version 1
* @since 31.08.2017
*/

public class CalculateTest {
/**
* Test echo.
*/
/**
* Test.
*/
@Test

public void whenTakeNameThenTreeEchoPlusName() {
  String input = "Tatyana Fukova";
 String expect = "Echo, echo, echo : Tatyana Fukova";
 //Создание нового объекта.
Calculate calc = new Calculate();

//Выполнение метода echo с параметром input и запись ее в переменную result.
String result = calc.echo(input);
//сравнение двух значений result и expect
assertThat(result, is(expect));
}

}