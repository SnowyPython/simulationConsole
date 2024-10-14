package ru.snowypython;

import ru.snowypython.entity.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Actions {
    public static int countPredators;
    public static int countHerbivores;

    public static void prepareSimulation() {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введите кол-во хищников");
            countPredators = Integer.parseInt(consoleReader.readLine());
            System.out.println("Введите кол-во травоядных");
            countHerbivores = Integer.parseInt(consoleReader.readLine());
        } catch (IOException e) {
            System.out.println("Некоректные данные");
        }
    }

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

        for (int grass = 0; grass < 3; grass++) {
            Coordinates randomCoordinates = createRandomCoordinates();
            map.setEntity(new Tree(randomCoordinates), randomCoordinates);
        }

        for (int grass = 0; grass < 3; grass++) {
            Coordinates randomCoordinates = createRandomCoordinates();
            map.setEntity(new Rock(randomCoordinates), randomCoordinates);
        }
    }

//    public static void makeMove(Map map) {
//        for (java.util.Map.Entry<Coordinates, Entity> entry : map.map.entrySet()) {
//            Entity entity = entry.getValue();
//            Creature creature = null;
//            if (entity instanceof Creature) {
//                creature = (Creature) entity;
//                creature.makeMove(map, creature.coordinates);
//            }
//        }
//    }

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

    public static Coordinates createRandomCoordinates() {
        File[] file = File.values();

        File randomFile = file[(int) (Math.random() * file.length)];
        Integer randomRank = (int) (Math.random() * 20) + 1;

        return new Coordinates(randomFile, randomRank);
    }
}
