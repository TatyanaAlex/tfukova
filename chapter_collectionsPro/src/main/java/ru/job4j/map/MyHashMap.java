package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class  MyHashMap.
 *
 * @author Tatyana Fukova
 * @version $I$
 */
public class MyHashMap<K, V> implements Iterable<V> {


    protected class HashMapArray<K, V> {

        private K key;
        private V value;

        /**
         * Constructor.
         *
         * @param key   key.
         * @param value value.
         */
        public HashMapArray(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMapArray[] mapArray = new HashMapArray[16];
    private int count = 0;
    private int modCount = 0;


    /**
     * method to insert the element.
     *
     * @param key   key.
     * @param value value.
     * @return result.
     */
    public boolean insert(K key, V value) {

        boolean result = false;
        if (key != null) {

            HashMapArray newArray = new HashMapArray(key, value);
            if (this.count == this.mapArray.length) {
                this.increaseSize();
            }

            int index = getIndex(key);

            if (this.mapArray[index] == null) {
                this.mapArray[index] = newArray;
                count++;
                modCount++;
                result = true;

            }
        }

        return result;

    }

    public int getIndex(K key) {
        return key.hashCode() & (this.mapArray.length - 1);
    }

    /**
     * method to increase the size of array.
     */
    public void increaseSize() {
        HashMapArray[] largeMap = new HashMapArray[this.mapArray.length * 2];

        for (HashMapArray hMa : this.mapArray) {
            int index = hMa.key.hashCode() & (largeMap.length - 1);
            largeMap[index] = hMa;

        }
        this.mapArray = largeMap;

    }

    /**
     * Method to get the value.
     *
     * @param key key.
     * @return value.
     */
    public V get(K key) {
        int index = getIndex(key);
        if (this.mapArray[index] == null || !key.equals(this.mapArray[index].key)) {
            return null;
        }
        return (V) this.mapArray[index].value;

    }


    /**
     * Method to delete the element.
     *
     * @param key key.
     * @return result.
     */
    public boolean delete(K key) {
        boolean result = false;

        if (key != null) {
            int index = getIndex(key);
            if (key.equals(this.mapArray[index].key)) {
                this.mapArray[index] = null;
                this.count--;
                modCount++;
                result = true;
            }

        }
        return result;
    }

    /**
     * Iterator method.
     *
     * @return iterator.
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            private int position = 0;
            private int iteratorCount = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (this.iteratorCount < count) {
                    result = true;
                }
                return result;
            }


            @Override
            public V next() {
                V result = null;
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (this.hasNext()) {
                    while (mapArray[this.position] == null) {
                        this.position++;
                    }
                    result = (V) mapArray[this.position];
                    this.position++;
                    this.iteratorCount++;
                } else {
                    throw new NoSuchElementException();
                }
                return result;

            }
        };
    }

}
