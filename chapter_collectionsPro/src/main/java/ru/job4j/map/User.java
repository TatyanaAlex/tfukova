package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;


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


    @Override
    public int hashCode() {

        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);

        return result;
    }
}
