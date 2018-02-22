package ru.job4j.tracker;

public interface UserAction {
    int key(); //метод определяет уникальность ключа
    void execute(Input input, Tracker tracker); //метод выполняет действия
    String info(); //метод печатает информаци о том что наше событие делает
}
