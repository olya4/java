package ru.geekbrains.homework5;

import java.util.ArrayList;
import java.util.Arrays;

// гонка
public class Race {
    // коллекция этапов
    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
