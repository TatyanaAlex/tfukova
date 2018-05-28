package ru.job4j.generics;

/**
 * @author Tatyana Fukova (tatyanafukova@gmail.com)
 * @version $Id$
 * @since 28.05
 */
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);

}
