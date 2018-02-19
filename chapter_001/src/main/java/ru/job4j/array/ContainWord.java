package ru.job4j.array;


public class ContainWord {

    boolean contains(String origin, String sub) {
        char[] arr = origin.toCharArray();
        char[] arr2 = sub.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr2[0]) {
                int found = 1;
                int currentPosition = i + 1;
                for (int j = 1; j < arr2.length; j++) {
                    if (arr2[j] == arr[currentPosition]) {
                        found++;
                        currentPosition++;
                    }
                }
                if (found == arr2.length) {
                    return true;
                }
            }
        }
        return false;
    }

}