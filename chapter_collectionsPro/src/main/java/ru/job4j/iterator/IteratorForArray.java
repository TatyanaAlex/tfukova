package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Class IteratorForArray.
 */
public class IteratorForArray implements Iterator {

    private final int[][] values;
    private int i = 0;
    private int j = 0;

    /**
     * Constructor.
     * @param values array.
     */
    public IteratorForArray(final int[][] values) {

        this.values = values;
    }

    /**
     * Method to check if there's next element.
     * @return true or false.
     */
    @Override
    public boolean hasNext() {
        return !(this.i == this.values.length && this.j == 0);
    }

    /**
     * Method to return the next element of array.
     * @return array's element.
     */
    @Override
    public Object next() {
           if (this.i == this.values.length && this.j == 0) {
               return null;
           } else {
               int nextElement = this.values[i][j];
               if (this.j == this.values[i].length - 1) {
                   this.j = 0;
                   this.i++;
               } else {
                   this.j++;
               }
               return nextElement;
           }
    }
}
