package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
        String name;
        int key;
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }
    public BaseAction() {
        //default constructor
    }
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }

}
