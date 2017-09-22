package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RotateArrayTest {
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 2 на 2.
        RotateArray rotateArray = new RotateArray();
        int[][] array = {{1, 5}, {6, 7}};
        int[][] expectArray = {{6, 1}, {7, 5}};
        int[][] resultArray = rotateArray.rotate(array);
        assertThat(resultArray, is(expectArray));

    }

    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 3 на 3.
        RotateArray rotateArray = new RotateArray();
        int[][] array = {{1, 5, 7}, {6, 7, 3}, {2, 9, 8}};
        int[][] expectArray = {{2, 6, 1}, {9, 7, 5}, {8, 3, 7}};
        int[][] resultArray = rotateArray.rotate(array);
        assertThat(resultArray, is(expectArray));
    }
}