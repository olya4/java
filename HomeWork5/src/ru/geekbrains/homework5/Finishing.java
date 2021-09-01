package ru.geekbrains.homework5;

import java.util.concurrent.CountDownLatch;

public class Finishing {

    private CountDownLatch countDownLatch;

    public Finishing(int carsCount) {
        this.countDownLatch = new CountDownLatch(carsCount);
    }
    // поставить в ожидание
    public void finishCar() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // освобождение ресурса
    public void notifyCar() {
        countDownLatch.countDown();
    }
}
