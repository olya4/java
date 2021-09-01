package ru.geekbrains.homework5;

// этап
public abstract class Stage {
    // длина
    protected int length;
    // описание
    protected String description;

    public String getDescription() {
        return description;
    }

    // машина поехала
    public abstract void go(Car c);
}