package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate{

    public String[] remove(String[] array){
          int unique = array.length;
        for (int i = 0; i < unique; i++) {

            for (int j = i + 1; j <unique ; j++) {

                if( array[i].equals(array[j])){
                    array[j] = array[unique - 1];
                    unique--;
                    j--;

                }

            }

        }

    return Arrays.copyOf(array, unique);
    }
}