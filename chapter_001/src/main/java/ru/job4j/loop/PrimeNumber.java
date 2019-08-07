package ru.job4j.loop;

public class PrimeNumber {

    /*
     * method has to count the number of primeNumbers from 1 to X
     */
    public int calc(int finish) {
        int count = 0;
        for (int i = 2; i <= finish; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) count++;
        }
        return count;
    }
}
