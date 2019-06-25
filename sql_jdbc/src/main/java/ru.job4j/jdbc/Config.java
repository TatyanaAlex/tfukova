package ru.job4j.jdbc;

import java.io.InputStream;
import java.util.Properties;

// класс загружает конфигурации из файла и потом с помощью метода ГЕТ достаёт по одному ключу.
public class Config {

    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("sqlite.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
