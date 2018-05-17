package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class PrimeIterator.
 */
public class PrimeIterator implements Iterator {

    final int[] numbers;
    private int position = 0;

    /**
     * Constructor.
     *
     * @param numbers array.
     */
    public PrimeIterator(int[] numbers) {
        this.numbers = numbers;
    }


    /**
     * Method to check if the number is prime.
     * @param number number to check.
     * @return result.
     */
    public boolean isSimpleNumber(int number) {
        boolean result = true;
        if (number > 1) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
    /**
     * Method to check if there's next prime element.
     * @return true or false.
     */
    @Override
    public boolean hasNext() {
        for (int i = this.position; i < this.numbers.length; i++) {
            if (isSimpleNumber(this.numbers[i])) {
                this.position = i;
                return true;
            }
        }
        return false;
    }

    /**
     * Method to return the next prime element of array.
     * @return array's prime element.
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

