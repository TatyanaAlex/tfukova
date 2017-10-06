package ru.job4j.profession;

public class Doctor extends Profession{

    boolean practiceAbroad = true;

    public String treat (Person person){
        return "Доктор " + "лечит пациента "+ person.name;

    }

    public String prescribeMedicine(String medicine){
        return "Доктор " + "выписывает лекарство "+ medicine;

    }
}
