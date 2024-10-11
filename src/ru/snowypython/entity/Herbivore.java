package ru.snowypython.entity;

import ru.snowypython.Coordinates;
import ru.snowypython.File;
import ru.snowypython.Map;
import ru.snowypython.queue.SimpleQueue;

import java.util.HashSet;
import java.util.Set;

public class Herbivore extends Creature {
    public static final Character icon = 'H';

    public Herbivore(Coordinates coordinates) {
        super(coordinates);
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
                    map.replaceEntity(this, coordinates, newCoordinates);
                    break outerLoop;
                } else if (newCoordinates != null && !visited.contains(newCoordinates)) {
                    visited.add(newCoordinates);
                }
            }
        }
    }
}
