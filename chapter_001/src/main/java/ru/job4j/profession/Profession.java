package ru.job4j.profession;

public class Profession {

    public Profession(){

    }

    public String specialization;

    public Profession (String specialization){
        this.specialization = specialization;

    }
    public String getSpecialization(){
        return this.specialization;
    }
}
