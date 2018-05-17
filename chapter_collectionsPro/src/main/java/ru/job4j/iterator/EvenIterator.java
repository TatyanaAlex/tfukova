package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIterator.
 */
public class EvenIterator implements Iterator {

    final int[] numbers;
    private int position = 0;

    /**
     * Constructor.
     * @param numbers array.
     */
    public EvenIterator(final int[] numbers) {
        this.numbers = numbers;
    }


    /**
     * Method to check if there's next element.
     * @return true or false.
     */
    @Override
    public boolean hasNext() {
        for (int i = this.position; i < numbers.length; i++) {
            if (this.numbers[i] % 2 == 0) {
                this.position = i;
                return true;
            }

        }
        return false;
    }

    /**
     * Method to return the next even element of array.
     * @return array's even element.
     */
    @Override
    public Object next() {
            if (hasNext()) {
                int tempPosition = this.position;
                this.position++;
                return this.numbers[tempPosition];
            }
        throw new NoSuchElementException();
    }




}
