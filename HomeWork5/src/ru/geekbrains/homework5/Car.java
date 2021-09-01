package ru.geekbrains.homework5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    // количество машин в гонке
    private static int CARS_COUNT;
    // гонка
    private Race race;
    // скорость
    private int speed;
    // имя участника
    private String name;
    // барьер
    private CyclicBarrier cyclicBarrier;

    private Finishing finishing;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

     // добавить в конструктор CyclicBarrier cyclicBarrier, Finishing finishing
    public Car(Race race, int speed, CyclicBarrier cyclicBarrier, Finishing finishing) {
        this.race = race;
        this.speed = speed;
        this.cyclicBarrier = cyclicBarrier;
        this.finishing = finishing;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            // подготовка
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            // барьер
            waitCar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // запуск гонки
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        // окончание гонки
        finishing.notifyCar();
    }

    // блокирует машины, до тех пор, пока все не будут готовы
    public void waitCar() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}


