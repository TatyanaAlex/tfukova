package ru.job4j.array;

public class RotateArray{

    public int[][] rotate(int[][] array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array.length ; j++) {

            }
        }

        for (int i = 0; i < array.length/2; i++) {
            for (int k = i; k <array.length - 1 -i ; k++) {
                int tmp = array[i][k];
                array [i][k] = array [array.length - k -1] [i];
                array [array.length - k -1] [i] = array[array.length -i - 1][array.length -k -1];
                array[array.length -i -1][array.length -k -1] = array[k][array.length -i -1];
                array[k][array.length -i -1] = tmp;
            }

        }

        return array;
    }





}