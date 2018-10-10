package ru.job4j.test;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $Id$
 * @since 0.9
 */
public class SameLettersTest {


    /**
     * Test method.
     */
    @Test
    public void ifWordsHaveSameLettersShouldReturnTrue() {
        char[] word1 = "mama".toCharArray();

        char[] word3 = "amama".toCharArray();

        SameLetters sameLetters = new SameLetters();

        assertTrue(sameLetters.isSameLetters(word1, word3));

    }

    /**
     * Test method.
     */
    @Test
    public void ifWordsAreAnagrammaShouldReturnTrue() {
        char[] word1 = "mama".toCharArray();
        char[] word2 = "amam".toCharArray();


        SameLetters sameLetters = new SameLetters();

        assertTrue(sameLetters.isAnagramma(word1, word2));

    }
}
