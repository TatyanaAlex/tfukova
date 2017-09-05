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
 //�������� ������ �������.
Calculate calc = new Calculate();

//���������� ������ echo � ���������� input � ������ �� � ���������� result.
String result = calc.echo(input);
//��������� ���� �������� result � expect
assertThat(result, is(expect));
}

}