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
    private boolean death = false;

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

    @Override
    public boolean isDeath() {
        return death;
    }

    @Override
    public void setDeath() {
        this.death = true;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void makeMove(Map map, Coordinates coordinates) {
        if (this.isDeath()) {
            return;
        }

        Coordinates targetGrass = findNearestGrass(map, coordinates);

        if (targetGrass != null) {
            if (canMoveTo(coordinates, targetGrass)) {
                map.replaceEntity(this, coordinates, targetGrass);
                this.setHp(getHp() + 1);
                Coordinates randomCoordinates = createRandomCoordinates();
                map.setEntity(new Grass(randomCoordinates), randomCoordinates);
            } else {
                moveTowardsTarget(map, coordinates, targetGrass);
            }
        }
    }

    private Coordinates findNearestGrass(Map map, Coordinates start) {
        SimpleQueue<Coordinates> queue = new SimpleQueue<>();
        Set<Coordinates> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        int[] dFile = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dRank = {-1, 0, 1, 1, 1, 0, -1, -1};

        while (!queue.isEmpty()) {
            Coordinates current = queue.remove();

            if (map.isSquareGrass(current)) {
                return current;
            }

            for (int i = 0; i < 8; i++) {
                int newFile = current.getFileInteger() + dFile[i];
                int newRank = current.getRank() + dRank[i];

                if (isValidCoordinate(newFile, newRank) && !visited.contains(new Coordinates(File.values()[newFile], newRank))) {
                    Coordinates newCoordinates = new Coordinates(File.values()[newFile], newRank);
                    visited.add(newCoordinates);
                    queue.add(newCoordinates);
                }
            }
        }
        return null;
    }

    private boolean isValidCoordinate(int file, int rank) {
        return file >= 0 && file < File.values().length && rank >= 1 && rank <= 20;
    }

    private boolean canMoveTo(Coordinates current, Coordinates target) {
        return Math.abs(target.getFileInteger() - current.getFileInteger()) <= getSpeed() &&
                Math.abs(target.getRank() - current.getRank()) <= getSpeed();
    }

    private void moveTowardsTarget(Map map, Coordinates current, Coordinates target) {
        int fileDiff = target.getFileInteger() - current.getFileInteger();
        int rankDiff = target.getRank() - current.getRank();

        int newFile = current.getFileInteger();
        int newRank = current.getRank();

        if (Math.abs(fileDiff) >= Math.abs(rankDiff)) {
            newFile = current.getFileInteger() + Integer.signum(fileDiff);
        }

        if (Math.abs(rankDiff) > Math.abs(fileDiff) || Math.abs(fileDiff) == Math.abs(rankDiff)) {
            newRank = current.getRank() + Integer.signum(rankDiff);
        }

        Coordinates newCoordinates = new Coordinates(File.values()[newFile], newRank);

        if (map.isSquareEmpty(newCoordinates)) {
            map.replaceEntity(this, current, newCoordinates);
        }
    }

    private static Coordinates createRandomCoordinates() {
        File[] file = File.values();

        File randomFile = file[(int) (Math.random() * file.length)];
        Integer randomRank = (int) (Math.random() * 20) + 1;

        return new Coordinates(randomFile, randomRank);
    }
}
