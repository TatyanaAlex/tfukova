package ru.job4j.strategyPattern;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StrategyPatternTest {

    @Test
    public void whenPicTriangleThenDrawTriangle() {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        String exampleTriangle = "  *  \n"+ " *** \n"+ "*****";
        assertThat(paint.getPicture(), is(exampleTriangle));
    }
    @Test
    public void whenPicSquareThenDrawSquare() {
        Paint paint = new Paint();
        paint.draw(new Square());
        String exampleSquare = "* * * *\n"+ "* * * *\n"+ "* * * *\n"+ "* * * *";
        assertThat(paint.getPicture(), is(exampleSquare));
    }
}
