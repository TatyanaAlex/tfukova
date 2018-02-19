package ru.job4j.max;

public class Max {
    public int max(int first, int second) {

        int maxim = (first > second) ? first : second;
        return maxim;
    }
    public int max(int first, int second, int third) {
        return (max(max(first, second), third));

    }

}