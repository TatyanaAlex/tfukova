package ru.job4j.inputoutput;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.*;

/**
 * Class AbuseDeleteTest.
 */
public class AbuseDeleteTest {

    /**
     * Test method.
     */
    @Test
    public void whenFindAbuseWordsShouldDelete() throws IOException {

        InputStream in = new ByteArrayInputStream("Hello you are amazing".getBytes());
        String[] array = {"Hello", "are"};


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        AbuseDelete abuseDelete = new AbuseDelete();
        abuseDelete.dropAbuses(in, out, array);

        assertThat(out.toString(), is("you amazing "));

    }
}
