package ru.job4j.socket;

import com.google.common.base.Joiner;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Class ServerTest.
 *
 * @author Tatyana (tatyanafukova@gmail.com)
 * @version 1
 * @since 18.02.19
 */
public class ServerTest {
    private static final String LN = System.getProperty("line.separator");

    /**
     * Test method.
     */
    @Test
    public void whenAskExitThenProgramEnds() throws IOException {
        this.testServer("exit", "");
    }

    /**
     * Test method.
     */
    @Test
    public void whenAskHelloThenOracleGreet() throws IOException {

        this.testServer(Joiner.on(LN).join("hello", "exit"),
                Joiner.on(LN).join("Hello, dear friend, I'm a oracle.", "", ""));

        /*Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(
                Joiner.on(LN).join("hello", "exit").getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.startServer();
        assertThat(out.toString(), is(Joiner.on(LN).join("Hello, dear friend, I'm a oracle.","", "")));
*/
    }


    /**
     * Test method.
     *
     * @param input    input.
     * @param expected expected.
     * @throws IOException IOException.
     */
    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(
                input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.startServer();
        assertThat(out.toString(), is(expected));

    }

}
