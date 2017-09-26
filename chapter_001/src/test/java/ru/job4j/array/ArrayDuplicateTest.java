package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] array =  {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expectArray = {"Привет", "Мир", "Супер"};
        String[] resultArray = duplicate.remove(array);
        assertThat(resultArray, is(expectArray));
    }
}