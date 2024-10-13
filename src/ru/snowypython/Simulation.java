package ru.snowypython;

import ru.snowypython.entity.*;

public class Simulation {
    public static void main(String[] args) {
        Map map = new Map();
        Herbivore herbivore = new Herbivore(new Coordinates(File.B, 2));
        Predator predator = new Predator(new Coordinates(File.F, 7));

        map.setEntity(herbivore, new Coordinates(File.B, 2));
        map.setEntity(predator, new Coordinates(File.F, 7));
        map.setEntity(new Grass(new Coordinates(File.A, 10)), new Coordinates(File.A, 10));
        map.setEntity(new Grass(new Coordinates(File.E, 6)), new Coordinates(File.E, 6));
        map.setEntity(new Grass(new Coordinates(File.S, 1)), new Coordinates(File.S, 1));
        map.setEntity(new Grass(new Coordinates(File.F, 13)), new Coordinates(File.F, 13));

        herbivore.makeMove(map, herbivore.coordinates);
        herbivore.makeMove(map, herbivore.coordinates);
        predator.makeMove(map, predator.coordinates);
        predator.makeMove(map, predator.coordinates);
        herbivore.makeMove(map, herbivore.coordinates);
        predator.makeMove(map, predator.coordinates);


        MapConsoleRenderer.render(map);
    }
}
