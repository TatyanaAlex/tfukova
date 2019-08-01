package ru.job4j.loop;

public class Fitness {

    /*
     * Метод должен вычислять количество месяцев, которое необходимо Ивану, чтобы обогнать в тяге Николая.
     */
    public int calc(int ivan, int nik) {
        int month = 0;
        while (ivan < nik) {
            ivan *= 3;
            nik *= 2;
            month++;
        }
        return month;

    }
}
