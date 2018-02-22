package ru.job4j.strategypattern;

public class Triangle implements Shape {

    @Override
    public String pic() {
        StringBuilder triangle = new StringBuilder();
        triangle.append("  *  \n");
        triangle.append(" *** \n");
        triangle.append("*****");
        return triangle.toString();
    }
}
