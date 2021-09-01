package ru.geekbrains.homework5;

import java.util.concurrent.*;

public class Beginning {

    private CyclicBarrier cyclicBarrier;
    private Finishing finishing;

    public Beginning(int carsCount, Finishing finishing) {
        this.cyclicBarrier = new CyclicBarrier(carsCount + 1);
        this.finishing = finishing;
    }

    // создание машины
    public Car createCar(Race race, int speed) {
        return new Car(race, speed, cyclicBarrier, finishing);
    }

    // одновременный старт
    public void startCar() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
