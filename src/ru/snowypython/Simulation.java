package ru.snowypython;

import ru.snowypython.entity.*;

public class Simulation {
    public static void main(String[] args) {
        Map map = new Map();
        Herbivore herbivore = new Herbivore(new Coordinates(File.B, 2));
        map.setEntity(herbivore, new Coordinates(File.B, 2));
        map.setEntity(new Grass(new Coordinates(File.S, 11)), new Coordinates(File.S, 11));
        map.setEntity(new Grass(new Coordinates(File.D, 12)), new Coordinates(File.D, 12));
        map.setEntity(new Grass(new Coordinates(File.F, 5)), new Coordinates(File.F, 5));
        herbivore.makeMove(map, herbivore.coordinates);

        MapConsoleRenderer.render(map);
    }
}
