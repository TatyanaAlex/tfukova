
/**
 * Package for ConsoleInput.
 * @author Tatyana Fukova (mailto: tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10.17
 */
package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10
 */
public class ConsoleInput implements Input {

    /**
     * @param scanner ** to read the user's input**
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method prints the question for users.
     * @param question ** ask the user to do something**
     * @return user's input
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }

        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
