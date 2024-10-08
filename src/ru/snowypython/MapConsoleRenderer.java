package ru.snowypython;

import ru.snowypython.entity.*;

public class MapConsoleRenderer {
    public static final Character defaultIcon = '0';

    public static void render(Map map) {
        for (File file : File.values()) {
            for (int rank = 1; rank <= 20; rank++) {
                if (map.isSquareEmpty(new Coordinates(file, rank))) {
                    System.out.print(defaultIcon + " ");
                } else if (map.isSquareGrass(new Coordinates(file, rank))) {
                    System.out.print(Grass.icon + " ");
                } else if (map.isSquareRock(new Coordinates(file, rank))) {
                    System.out.print(Rock.icon + " ");
                } else if (map.isSquareTree(new Coordinates(file, rank))) {
                    System.out.print(Tree.icon + " ");
                } else if (map.isSquarePredator(new Coordinates(file, rank))) {
                    System.out.print(Predator.icon + " ");
                } else if (map.isSquareHerbivore(new Coordinates(file, rank))) {
                    System.out.print(Herbivore.icon + " ");
                }
            }
            System.out.println();
        }
    }
}