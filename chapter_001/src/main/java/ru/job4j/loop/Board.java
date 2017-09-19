package ru.job4j.loop;

public class Board {

    public String paint(int width, int height) {
        int index = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (index == 1) {
                    builder.append("x");
                    index = 0;
                } else {
                    builder.append(" ");
                    index = 1;
                }
            }
            builder.append(System.getProperty("line.separator"));
        }
        String result = builder.toString();
        return result;
    }
}