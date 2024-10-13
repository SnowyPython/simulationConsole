package ru.snowypython;

import ru.snowypython.entity.*;

public class Simulation {
    public static void main(String[] args) {
        Map map = new Map();

        map.setEntity(new Herbivore(new Coordinates(File.M, 5)), new Coordinates(File.M, 5));
        map.setEntity(new Predator(new Coordinates(File.K, 9)), new Coordinates(File.K, 9));

        map.setEntity(new Grass(new Coordinates(File.C, 10)), new Coordinates(File.C, 10));
        map.setEntity(new Grass(new Coordinates(File.D, 9)), new Coordinates(File.D, 9));
        map.setEntity(new Grass(new Coordinates(File.G, 11)), new Coordinates(File.G, 11));
        map.setEntity(new Grass(new Coordinates(File.L, 9)), new Coordinates(File.L, 9));

        MapConsoleRenderer.render(map);
        System.out.println();
    }
}
