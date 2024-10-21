package ru.snowypython;

import ru.snowypython.entity.*;

import java.util.Set;

public class Simulation {
    public static void main(String[] args) {
        Map map = new Map();

        Actions.prepareSimulation();

        Set<Herbivore> herbivores = Actions.createHerbivoreSet(Actions.countHerbivores);
        Set<Predator> predators = Actions.createPredatorSet(Actions.countPredators);

        Actions.setStartMap(map, herbivores, predators);

        MapConsoleRenderer.render(map);

        Actions.makeMove(map);
        Actions.makeMove(map);

        MapConsoleRenderer.render(map);
    }
}
