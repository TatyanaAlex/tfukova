package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter.
 */
public class Converter {

    Iterator<Integer> currentIt = null;
    Iterator<Iterator<Integer>> generalIt = null;


    /**
     * Method to convert Iterator of iterators to iterator of numbers.
     *
     * @param it iterator of iterators.
     * @return iterator of numbers.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.generalIt = it;
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                chooseCurrentIterator();
                return currentIt.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return currentIt.next();
            }
        };
    }

    /**
     * Method to choose the current iterator.
     */
    private void chooseCurrentIterator() {
        if (currentIt == null || !currentIt.hasNext()) {
            if (generalIt.hasNext()) {
                currentIt = generalIt.next();
            }
        }
    }


}
