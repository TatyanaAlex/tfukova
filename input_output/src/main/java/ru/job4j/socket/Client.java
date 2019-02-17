package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private int port = 5000;
    private String ip = "127.0.0.1";
    private Socket socket;


    public void startClient() throws IOException {
        socket = new Socket(InetAddress.getByName(ip), port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String str = null;
        do {
            out.println("Hello oracle");
            str = in.readLine();
            System.out.println(str);
            out.println(str);
        } while ("exit".equals(str));
    }

}
