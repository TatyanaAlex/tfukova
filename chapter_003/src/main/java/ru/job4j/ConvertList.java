package ru.job4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Class ConvertList.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 17.12
 */
public class ConvertList {

    /**
     * Method to convert array to list.
     * @param array double array.
     * @return list.
     */
    public List<Integer> toList(int[][] array) {

        List<Integer> list = new ArrayList<>();
        for (int[] x  : array) {
            for (int y : x) {
                list.add(Integer.valueOf(y));
            }
        }
    return list;
    }

    /**
     * Method to convert list to array.
     * @param list given collection.
     * @param rows number of rows in the array
     * @return array.
     */
    public int[][] toArray(List<Integer> list, int rows) {

        int rowlength = list.size() / rows;
        rowlength += list.size() % rows;
        Iterator iterator = list.iterator();
        int[][] array = new int[rows][rowlength];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rowlength; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = Integer.parseInt(iterator.next().toString());
                } else {
                    array[i][j] = 0;
                }

            }

        }

         return array;
    }
    /**
     * Method to convert list of array to List of Integers.
     * @param list given list of arrays.
     * @return List of Integers.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> finalList = new ArrayList<>();
        for (int[]array : list) {
            for (int i : array) {
                finalList.add(i);
            }
        }

        return finalList;
    }
}
