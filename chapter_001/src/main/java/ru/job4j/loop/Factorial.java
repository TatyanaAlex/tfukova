package ru.job4j.loop;

public class Factorial{

    public int calc(int n) {
        int factor = 1;

        for (int i = 1; i <= n; i++){
            { if (n == 0){
                return 1;
            }
                factor = factor*i;
            }
        }
        return factor;
    }

}