package ru.snowypython;

import ru.snowypython.entity.Herbivore;
import ru.snowypython.entity.Predator;

import java.util.HashSet;

public class CreateSets {
    public static HashSet<Herbivore> createHerbivoreSet(int countHerbivores) {
        HashSet<Herbivore> set = new HashSet<>();

        for (int i = 0; i < countHerbivores; i++) {
            set.add(new Herbivore(createRandomCoordinates()));
        }

        return set;
    }

    public static HashSet<Predator> createPredatorSet(int countPredators) {
        HashSet<Predator> set = new HashSet<>();

        for (int i = 0; i < countPredators; i++) {
            set.add(new Predator(createRandomCoordinates()));
        }

        return set;
    }

    private static Coordinates createRandomCoordinates() {
        File[] file = File.values();

        File randomFile = file[(int) (Math.random() * file.length)];
        Integer randomRank = (int) (Math.random() * 20) + 1;

        return new Coordinates(randomFile, randomRank);
    }
}
