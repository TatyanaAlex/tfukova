package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.*;
import ru.job4j.inputoutput.CheckByteStream;
import java.io.ByteArrayInputStream;

/**
 * Class CheckByteStreamTest.
 */
public class CheckByteStreamTest {

    /**
     * Test method.
     */
    @Test
    public void ifContainsOddNumberReturnTrue() {

        ByteArrayInputStream in = new ByteArrayInputStream("8".getBytes());

        CheckByteStream checkByteStream = new CheckByteStream();

        assertTrue(checkByteStream.isNumber(in));

    }
}
