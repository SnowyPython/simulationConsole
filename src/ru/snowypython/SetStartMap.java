package ru.snowypython;

import ru.snowypython.entity.*;

import java.util.Set;

public class SetStartMap extends Actions {
    public static void setStartMap(Map map, Set<Herbivore> herbivores, Set<Predator> predators) {
        for (Herbivore herbivore : herbivores) {
            map.setEntity(herbivore, herbivore.coordinates);
        }

        for (Predator predator : predators) {
            map.setEntity(predator, predator.coordinates);
        }

        for (int grass = 0; grass < 5; grass++) {
            Coordinates randomCoordinates = createRandomCoordinates();
            map.setEntity(new Grass(randomCoordinates), randomCoordinates);
        }

        for (int tree = 0; tree < 3; tree++) {
            Coordinates randomCoordinates = createRandomCoordinates();
            map.setEntity(new Tree(randomCoordinates), randomCoordinates);
        }

        for (int rock = 0; rock < 3; rock++) {
            Coordinates randomCoordinates = createRandomCoordinates();
            map.setEntity(new Rock(randomCoordinates), randomCoordinates);
        }
    }

    private static Coordinates createRandomCoordinates() {
        File[] file = File.values();

        File randomFile = file[(int) (Math.random() * file.length)];
        Integer randomRank = (int) (Math.random() * 20) + 1;

        return new Coordinates(randomFile, randomRank);
    }
}
