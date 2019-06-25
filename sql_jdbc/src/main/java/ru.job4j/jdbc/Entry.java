package ru.job4j.jdbc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// оболочка для строки в бд
@XmlRootElement
public class Entry {
    private int id;

    public Entry(int id) {
        this.id = id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
