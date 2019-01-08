package ru.job4j.inputoutput;

import java.io.*;
import java.util.Scanner;

/**
 * Class AbuseDelete.
 */
public class AbuseDelete {


    /**
     * dropAbuses method.
     *
     * @param in    - InputStream.
     * @param out   - OutputStream.
     * @param abuse - String[].
     * @throws IOException - IOException.
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {

        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()) {
            String temp = scanner.next();
            boolean isAbuse = false;
            for (int i = 0; i < abuse.length; i++) {
                if (abuse[i].equals(temp)) {
                    isAbuse = true;
                }

            }
            if (!isAbuse) {
                temp += " ";
                out.write(temp.getBytes());

            }

        }
        out.close();


    }
}