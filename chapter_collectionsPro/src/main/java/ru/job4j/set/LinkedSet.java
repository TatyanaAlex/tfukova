package ru.job4j.set;

import ru.job4j.list.NodeList;

import java.util.Iterator;


/**
 * Class  LinkedSet.
 *
 * @author Tatyana Fukova
 * @version $I$
 */
public class LinkedSet<E> implements Iterable<E> {


    NodeList<E> nodeList = new NodeList<>();


    /**
     * Method to add new element.
     */
    public void add(E data) {
        if (!this.duplicate(data)) {
            nodeList.add(data);
        }

    }

    /**
     * Method to check the duplicated elements.
     */
    private boolean duplicate(E value) {
        for (int i = 0; i < nodeList.getSize(); i++) {
            if (value.equals(get(i))) {
                return true;
            }
        }
        return false;
    }


    /**
     * Method to get the element.
     */
    public E get(int index) {

        return nodeList.get(index);

    }

    @Override
    public Iterator<E> iterator() {
        return nodeList.iterator();
    }


}
