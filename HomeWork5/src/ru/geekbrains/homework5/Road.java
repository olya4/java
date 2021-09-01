package ru.geekbrains.homework5;

// дорога
public class Road extends Stage {
    public Road(int length) {
        // длина
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    // машина поехала по дороге
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}