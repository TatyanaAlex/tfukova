package ru.job4j.modeluser;

/**
 * Class User.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 18.01
 */
     public class User implements Comparable<User> {

    String name;
    Integer age;

    /**
     * Constructor.
     * @param name
     * @param age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}




