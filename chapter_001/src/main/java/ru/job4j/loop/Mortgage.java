package ru.job4j.loop;

public class Mortgage {

    public int year(int amount, int monthly, double percent) {

        int year = 0;
        double total = ((amount * percent) / 100) + amount;
        int yearly = monthly * 12;
        while (total > 0) {
            total -= yearly;
            year++;
        }

        return year;
    }

}
