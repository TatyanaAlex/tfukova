package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;
import java.util.Scanner;

/**
 * Class Client.
 *
 * @author Tatyana (tatyanafukova@gmail.com)
 * @version 1
 * @since 18.02.19
 */
public class Client {
    public static final int PORT = 5000;
    private final Socket socket;

    /**
     * Constructor.
     */
    public Client(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws IOException {
        try (final Socket socket = new Socket("127.0.0.1", PORT)) {
            new Client(socket);
        }

    }


    /**
     * method to analyze client´s input.
     */
    public void startClient() throws IOException {

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String str = null;
        do {
            System.out.println("Enter message for oracle: ");
            str = in.readLine();
            System.out.println(str);
            out.println(str);
        } while (!("exit".equals(str)));
    }


}
