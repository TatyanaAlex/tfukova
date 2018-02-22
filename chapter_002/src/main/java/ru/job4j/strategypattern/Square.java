package ru.job4j.strategypattern;

public class Square implements Shape {

    @Override
    public String pic() {
        StringBuilder square = new StringBuilder();
        square.append("* * * *\n");
        square.append("* * * *\n");
        square.append("* * * *\n");
        square.append("* * * *");
        return square.toString();
    }
}
