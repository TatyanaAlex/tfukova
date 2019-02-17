package ru.job4j.inputoutput;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Tatyana (tatyanafukova@gmail.com)
 * @version 1
 * @since 06.02.19
 */
public class ChatTest {
    /**
     * @test method.
     */
    @Test
    public void whenYouTalkWithBot() throws Exception {
        Chat chat = new Chat();
        String phrase = "hi well stop good continue nice finish";
        ByteArrayInputStream in = new ByteArrayInputStream(phrase.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        chat.initial();
        String result = out.toString();
        assertThat(result.substring(result.length() - 8, result.length() - 1), is("Goodbye"));
    }
}
