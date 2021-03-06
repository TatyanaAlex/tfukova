package ru.job4j.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Tatyana (mailto:tatyanafukova@gmail.com)
 * @version $Id$
 * @since 0.9
 */

public class SameLetters {
    

    Map<Character, Integer> lettersInWord1 = new HashMap<Character, Integer>();


    /**
     * method to check if the words contains the same letters.
     *
     * @return result.
     */
    public boolean isSameLetters(char[] word1, char[] word3) {

        lettersInWord1 = new TreeMap<>();
        for (char tempor : word1) {
            lettersInWord1.put(tempor, 1);
        }
        Map<Character, Integer> lettersInWord3 = new TreeMap<>();
        for (char temporar : word3) {

            lettersInWord3.put(temporar, 1);
        }
        return lettersInWord1.equals(lettersInWord3);
    }

    /**
     * method to check if the words are anagramms.
     *
     * @return result.
     */
    public boolean isAnagramma(char[] word1, char[] word2) {

        for (char temp : word1) {
            int count = 1;
            if (lettersInWord1.containsKey(temp)) {
                count = lettersInWord1.get(temp) + 1;
            }
            lettersInWord1.put(temp, count);
        }
        for (char tempr : word2) {
            int count = -1;
            if (lettersInWord1.containsKey(tempr)) {
                count = lettersInWord1.get(tempr) - 1;
            }
            lettersInWord1.put(tempr, count);
        }

        for (char c : lettersInWord1.keySet()) {
            if (lettersInWord1.get(c) != 0) {
                return false;
            }
        }

        return true;

    }

}
