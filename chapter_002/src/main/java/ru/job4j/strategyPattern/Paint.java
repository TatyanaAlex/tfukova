package ru.job4j.strategyPattern;

public class Paint{

    private String picture = "";

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void draw(Shape shape){
        System.out.println(shape.pic());
        setPicture(shape.pic());
    }
}