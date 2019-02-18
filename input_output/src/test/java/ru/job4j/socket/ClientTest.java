package ru.job4j.socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class ClientTest.
 *
 * @author Tatyana (tatyanafukova@gmail.com)
 * @version 1
 * @since 18.02.19
 */
public class ClientTest {
    private static final String LN = System.getProperty("line.separator");

    /**
     * Test method.
     */
    @Test
    public void whenSayHelloAndExit() throws IOException {
        this.testClient(
                Joiner.on(LN).join(
                        "Hello oracle",
                        "exit"
                ),
                Joiner.on(LN).join(
                        "Hello oracle",
                        "exit",
                        ""
                )
        );

    }

    /**
     * Test method.
     *
     * @param input    input.
     * @param expected expected.
     * @throws IOException IOException.
     */
    private void testClient(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(
                input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.startClient();
        assertThat(out.toString(), is(expected));

    }

}
