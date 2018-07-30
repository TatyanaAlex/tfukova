package ru.job4j.map;

import java.util.Calendar;

/**
 * Class  User.
 *
 * @author Tatyana Fukova
 * @version $I$
 */
public class User {

    private String name;
    private int children;
    private Calendar birthday;

    /**
     * Constructor.
     *
     * @param name     user´s name.
     * @param children children.
     * @param birthday dates of birthday.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
