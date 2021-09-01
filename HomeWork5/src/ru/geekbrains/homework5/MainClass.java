package ru.geekbrains.homework5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    // количество машин в гонке
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);
        Finishing finishing = new Finishing(CARS_COUNT);
        Beginning beginning = new Beginning(CARS_COUNT, finishing);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        // создать гонку (дорога, тоннель, дорога)
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));

        // создать массив машин
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = beginning.createCar(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            executorService.execute(car);
        }

        // гонка началась
        beginning.startCar();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        // гонка закончилась
        finishing.finishCar();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        executorService.shutdown();
    }
}
