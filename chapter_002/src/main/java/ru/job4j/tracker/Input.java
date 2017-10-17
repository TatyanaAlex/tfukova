package ru.job4j.tracker;

/**
 * Interface Input.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10
 */
public interface Input {

    /**
     * @param question ** question to ask to user**
     * @return question
     */
    String ask(String question);
}