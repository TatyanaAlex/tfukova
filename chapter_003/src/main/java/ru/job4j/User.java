package ru.job4j;

/**
 * Class User.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 07.01
 */
public class User {
    int id;
    String name;
    String city;

    /**
     * Constructor.
     * @param id
     * @param city
     * @param name
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
