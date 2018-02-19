package ru.job4j.profession;

public class Teacher extends Profession {
    String name = "Василий";

    public String teach(Student student) {
       return "Учитель " + name + " учит студента " + student.name;
    }
    public String evaluate(Student student) {

        return "Учитель " + name + " оценивает студента " + student.name;

    }
}