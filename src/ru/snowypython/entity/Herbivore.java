package ru.snowypython.entity;

import ru.snowypython.Coordinates;
import ru.snowypython.Map;
import ru.snowypython.queue.SimpleQueue;

public class Herbivore extends Creature {
    public static final Character icon = 'H';

    public Herbivore(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void makeMove(Map map, Coordinates coordinates) {
        SimpleQueue<Coordinates> queue = new SimpleQueue<>();
        queue.add(coordinates);

        while (!queue.isEmpty()) {
            Coordinates center = queue.remove();
            Integer centerFileInteger = center.getFileInteger();
            Integer centerRank = center.getRank();
            
        }
    }
}
