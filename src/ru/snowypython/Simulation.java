package ru.snowypython;

import ru.snowypython.entity.*;

import java.util.Set;

public class Simulation {
    public static void main(String[] args) {
        Map map = new Map();

        PrepareSimulation.prepareSimulation();

        Set<Herbivore> herbivores = CreateSets.createHerbivoreSet(PrepareSimulation.countHerbivores);
        Set<Predator> predators = CreateSets.createPredatorSet(PrepareSimulation.countPredators);

        SetStartMap.setStartMap(map, herbivores, predators);

        MapConsoleRenderer.render(map);

        for (int i = 0; i < 12; i++) {
            MakeMove.makeMove(map);
            MapConsoleRenderer.render(map);
        }
    }
}
