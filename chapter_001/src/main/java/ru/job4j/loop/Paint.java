package ru.job4j.loop;

public class Paint{

    public String piramid(int h){
        int width = h*2-1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= h ; i++) {
            int spacesQuantity = h-i;
            int xQuantity = width-(spacesQuantity*2);
            for (int j = 0; j < width; j++) {
                if(spacesQuantity > 0) {
                builder.append(" ");
                spacesQuantity--;
                }
                else if(xQuantity > 0) {
                builder.append("^");
                xQuantity--;
                }else{
                builder.append(" ");
                }
                }
            builder.append(System.getProperty("line.separator"));
            }
        builder.setLength(builder.length()-2);
        return builder.toString();
        }


    }
