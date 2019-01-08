package ru.job4j.inputoutput;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class CheckByteStream.
 */
public class CheckByteStream {

    /**
     * method to check if the stream has an odd number.
     *
     * @param in input stream.
     */
    public boolean isNumber(InputStream in) {
        boolean result = false;
        Scanner scanner = new Scanner(in);

        int data = scanner.nextInt();
        scanner.close();
        if (data % 2 == 0) {
            result = true;
        }

        return result;

    }
}
