package ru.job4j.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class ListCompare.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 18.01
 */
public class ListCompare implements Comparator<List<Integer>> {
    /**
     * Method to compare two lists.
     * @param left, right  two given lists.
     * @return result.
     */
    @Override
    public int compare(List<Integer> left, List<Integer> right) {

        Collections.sort(left);
        Collections.sort(right);

        int maxLenght = 0;
        if (left.size() <= right.size()) {
            maxLenght = left.size();
        } else {
            maxLenght = right.size();
        }

        int result = 0;
        for (int i = 0; i < maxLenght; i++) {
            if (left.get(i).compareTo(right.get(i)) == 0) {
                continue;
            } else {
                result = left.get(i).compareTo(right.get(i));
            }
        }
        int diff = left.size() - right.size();
        if (diff < 0 && result == 0) {
            result = -1;
        } else if (diff > 0 && result == 0) {
            result = 1;
        }
        return result;
    }
}