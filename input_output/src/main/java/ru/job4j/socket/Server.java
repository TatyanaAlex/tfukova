package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class Server.
 *
 * @author Tatyana (tatyanafukova@gmail.com)
 * @version 1
 * @since 18.02.19
 */
public class Server {

    private final Socket socket;

    /**
     * Constructor.
     */
    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * method to start the Server.
     */
    public void startServer() throws IOException {

        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String ask = null;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            }
        } while ("exit".equals(ask));
    }

    public static void main(String[] args) throws IOException {
        try (final Socket socket = new ServerSocket(1111).accept()) {
            new Server(socket);
        }
    }

}
