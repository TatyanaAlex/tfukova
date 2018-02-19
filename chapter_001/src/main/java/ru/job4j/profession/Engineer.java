package ru.job4j.profession;

public class Engineer extends Profession {

        int yearsOfExperience = 5;

    public String developCar(String automobile) {
        return "Инженер с " + yearsOfExperience + " стажем разрабатывает " + automobile;

    }


}
