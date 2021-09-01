package ru.geekbrains.homework5;

import java.util.concurrent.Semaphore;

// тоннель
public class Tunnel extends Stage {

    private final Semaphore maxCar;

    public Tunnel(int carsCount) {
        // длина
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.maxCar = new Semaphore(carsCount / 2, true);
    }

    // машина поехала по тоннелю
    @Override
    public void go(Car c) {
        try {
            try {

                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                maxCar.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                maxCar.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
