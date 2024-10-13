package ru.snowypython.entity;

import ru.snowypython.Coordinates;
import ru.snowypython.File;
import ru.snowypython.Map;
import ru.snowypython.queue.SimpleQueue;

import java.util.HashSet;
import java.util.Set;

public class Herbivore extends Creature {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String icon = ANSI_YELLOW + 'H' + ANSI_RESET;
    public static final int maxHp = 5;

    private final int speed = 3;
    private int hp;

    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        this.hp = maxHp;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void makeMove(Map map, Coordinates coordinates) {
        final int MAX_RANG = 20;

        int[] dFile = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dRank = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        File[] file = File.values();

        SimpleQueue<Coordinates> queue = new SimpleQueue<>();
        Set<Coordinates> visited = new HashSet<>();

        queue.add(coordinates);
        visited.add(coordinates);

        outerLoop:
        while (!queue.isEmpty()) {
            Coordinates center = queue.remove();
            Integer centerFileInteger = center.getFileInteger();
            Integer centerRank = center.getRank();

            for (int i = 0; i < 8; i++) {
                int newFile = centerFileInteger + dFile[i];
                int newRank = centerRank + dRank[i];

                Coordinates newCoordinates = null;
                if (newFile >= 0 && newRank >= 1 && newFile < file.length && newRank <= MAX_RANG) {
                    newCoordinates = new Coordinates(file[newFile], newRank);
                }

                if (newCoordinates != null && !visited.contains(newCoordinates) && map.isSquareEmpty(newCoordinates)) {
                    queue.add(newCoordinates);
                    visited.add(newCoordinates);
                } else if (newCoordinates != null && !visited.contains(newCoordinates) && map.isSquareGrass(newCoordinates)) {
                    if (Math.abs(newCoordinates.getFileInteger() - coordinates.getFileInteger()) <= speed && Math.abs(newCoordinates.getRank() - coordinates.getRank()) <= speed) {
                        this.setHp(getHp() + 1);
                        map.replaceEntity(this, coordinates, newCoordinates);
                    } else {
                        File newRandomFile = file[coordinates.getFileInteger() + (int) (Math.random() * 3) - 1];
                        Integer newRandomRank = coordinates.getRank() + (int) (Math.random() * 3) - 1;
                        if (map.isSquareEmpty(new Coordinates(newRandomFile, newRandomRank))) {
                            map.replaceEntity(this, coordinates, new Coordinates(newRandomFile, newRandomRank));
                        }
                    }
                    break outerLoop;
                } else if (newCoordinates != null && !visited.contains(newCoordinates)) {
                    visited.add(newCoordinates);
                }
            }
        }
    }
}
