package ru.job4j.synchronize;

import ru.job4j.list.DynamicList;

import java.util.Iterator;

import net.jcip.annotations.ThreadSafe;


/**
 * Class ThreadSafeDynamicList.
 */
@ThreadSafe
public class ThreadSafeDynamicList<E> {


    private DynamicList<E> dl = new DynamicList<E>(5);

    /**
     * Method to add new element.
     */
    public synchronized void add(E value) {
        dl.add(value);
    }

    /**
     * Method to get the element.
     */
    public synchronized E get(int index) {
        return dl.get(index);

    }

    /**
     * Method to copy object.
     */
    private DynamicList<E> copy() {

        DynamicList<E> tempList = new DynamicList<E>(5);

        Iterator<E> it = this.dl.iterator();
        while (it.hasNext()) {
            tempList.add(it.next());
        }
        return tempList;
    }

    public synchronized Iterator<E> iterator() {

        return copy().iterator();
    }


}
