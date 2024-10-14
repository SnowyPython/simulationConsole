package ru.snowypython;

import ru.snowypython.entity.*;

import java.util.HashMap;
import java.util.Set;

public class Simulation {
    public static void main(String[] args) {
        Map map = new Map();

        Actions.prepareSimulation();

        Set<Herbivore> herbivores = Actions.createHerbivoreSet(Actions.countHerbivores);
        Set<Predator> predators = Actions.createPredatorSet(Actions.countPredators);

        for (Herbivore herbivore : herbivores) {
            map.setEntity(herbivore, herbivore.coordinates);
        }

        for (Predator predator : predators) {
            map.setEntity(predator, predator.coordinates);
        }

        MapConsoleRenderer.render(map);
    }
}
