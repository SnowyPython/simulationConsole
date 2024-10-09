package ru.snowypython.entity;

import ru.snowypython.Coordinates;
import ru.snowypython.File;
import ru.snowypython.Map;
import ru.snowypython.queue.SimpleQueue;

public class Herbivore extends Creature {
    public static final Character icon = 'H';

    public Herbivore(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void makeMove(Map map, Coordinates coordinates) {
        File[] file = File.values();
        SimpleQueue<Coordinates> queue = new SimpleQueue<>();
        queue.add(coordinates);

        while (!queue.isEmpty()) {
            Coordinates center = queue.remove();
            Integer centerFileInteger = center.getFileInteger();
            Integer centerRank = center.getRank();

            if (centerFileInteger - 1 >= 0 && centerRank - 1 >= 1 && centerFileInteger - 1 < file.length &&
                    centerRank - 1 <= 20 && map.isSquareEmpty(new Coordinates(file[centerFileInteger - 1], centerRank - 1))) {
                queue.add(new Coordinates(file[centerFileInteger - 1], centerRank - 1));
            }

            if (centerFileInteger - 1 >= 0 && centerRank - 1 >= 1 && centerFileInteger - 1 < file.length &&
                    centerRank - 1 <= 20 && map.isSquareGrass(new Coordinates(file[centerFileInteger - 1], centerRank - 1))) {
                map.replaceEntity(this, coordinates, new Coordinates(file[centerFileInteger - 1], centerRank - 1));
                break;
            }

            if (centerFileInteger - 1 >= 0 && centerRank >= 1 && centerFileInteger - 1 < file.length &&
                    centerRank <= 20 && map.isSquareEmpty(new Coordinates(file[centerFileInteger - 1], centerRank))) {
                queue.add(new Coordinates(file[centerFileInteger - 1], centerRank));
            }

            if (centerFileInteger - 1 >= 0 && centerRank >= 1 && centerFileInteger - 1 < file.length &&
                    centerRank <= 20 && map.isSquareGrass(new Coordinates(file[centerFileInteger - 1], centerRank))) {
                map.replaceEntity(this, coordinates, new Coordinates(file[centerFileInteger - 1], centerRank));
                break;
            }

            if (centerFileInteger - 1 >= 0 && centerRank + 1 >= 1 && centerFileInteger - 1 < file.length &&
                    centerRank + 1 <= 20 && map.isSquareEmpty(new Coordinates(file[centerFileInteger - 1], centerRank + 1))) {
                queue.add(new Coordinates(file[centerFileInteger - 1], centerRank + 1));
            }

            if (centerFileInteger - 1 >= 0 && centerRank + 1 >= 1 && centerFileInteger - 1 < file.length &&
                    centerRank + 1 <= 20 && map.isSquareGrass(new Coordinates(file[centerFileInteger - 1], centerRank + 1))) {
                map.replaceEntity(this, coordinates, new Coordinates(file[centerFileInteger - 1], centerRank + 1));
                break;
            }

            if (centerFileInteger >= 0 && centerRank + 1 >= 1 && centerFileInteger < file.length &&
                    centerRank + 1 <= 20 && map.isSquareEmpty(new Coordinates(file[centerFileInteger], centerRank + 1))) {
                queue.add(new Coordinates(file[centerFileInteger], centerRank + 1));
            }

            if (centerFileInteger >= 0 && centerRank + 1 >= 1 && centerFileInteger < file.length &&
                    centerRank + 1 <= 20 && map.isSquareGrass(new Coordinates(file[centerFileInteger], centerRank + 1))) {
                map.replaceEntity(this, coordinates, new Coordinates(file[centerFileInteger], centerRank + 1));
                break;
            }

            if (centerFileInteger + 1 >= 0 && centerRank + 1 >= 1 && centerFileInteger + 1 < file.length &&
                    centerRank + 1 <= 20 && map.isSquareEmpty(new Coordinates(file[centerFileInteger + 1], centerRank + 1))) {
                queue.add(new Coordinates(file[centerFileInteger + 1], centerRank + 1));
            }

            if (centerFileInteger + 1 >= 0 && centerRank + 1 >= 1 && centerFileInteger + 1 < file.length &&
                    centerRank + 1 <= 20 && map.isSquareGrass(new Coordinates(file[centerFileInteger + 1], centerRank + 1))) {
                map.replaceEntity(this, coordinates, new Coordinates(file[centerFileInteger + 1], centerRank + 1));
                break;
            }

            if (centerFileInteger + 1 >= 0 && centerRank >= 1 && centerFileInteger + 1 < file.length &&
                    centerRank <= 20 && map.isSquareEmpty(new Coordinates(file[centerFileInteger + 1], centerRank))) {
                queue.add(new Coordinates(file[centerFileInteger + 1], centerRank));
            }

            if (centerFileInteger + 1 >= 0 && centerRank >= 1 && centerFileInteger + 1 < file.length &&
                    centerRank <= 20 && map.isSquareGrass(new Coordinates(file[centerFileInteger + 1], centerRank))) {
                map.replaceEntity(this, coordinates, new Coordinates(file[centerFileInteger + 1], centerRank));
                break;
            }

            if (centerFileInteger + 1 >= 0 && centerRank - 1 >= 1 && centerFileInteger + 1 < file.length &&
                    centerRank - 1 <= 20 && map.isSquareEmpty(new Coordinates(file[centerFileInteger + 1], centerRank - 1))) {
                queue.add(new Coordinates(file[centerFileInteger + 1], centerRank - 1));
            }

            if (centerFileInteger + 1 >= 0 && centerRank - 1 >= 1 && centerFileInteger + 1 < file.length &&
                    centerRank - 1 <= 20 && map.isSquareGrass(new Coordinates(file[centerFileInteger + 1], centerRank - 1))) {
                map.replaceEntity(this, coordinates, new Coordinates(file[centerFileInteger + 1], centerRank - 1));
                break;
            }

            if (centerFileInteger >= 0 && centerRank - 1 >= 1 && centerFileInteger < file.length &&
                    centerRank - 1 <= 20 && map.isSquareEmpty(new Coordinates(file[centerFileInteger], centerRank - 1))) {
                queue.add(new Coordinates(file[centerFileInteger], centerRank - 1));
            }

            if (centerFileInteger >= 0 && centerRank - 1 >= 1 && centerFileInteger < file.length &&
                    centerRank - 1 <= 20 && map.isSquareGrass(new Coordinates(file[centerFileInteger], centerRank - 1))) {
                map.replaceEntity(this, coordinates, new Coordinates(file[centerFileInteger], centerRank - 1));
                break;
            }
        }
    }
}
