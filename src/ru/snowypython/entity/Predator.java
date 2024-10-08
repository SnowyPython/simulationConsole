package ru.snowypython.entity;

import ru.snowypython.Coordinates;
import ru.snowypython.Map;
import ru.snowypython.queue.SimpleQueue;

public class Predator extends Creature {
    public static final Character icon = 'P';

    private int power;

    public Predator(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void makeMove(Map map, Coordinates coordinates) {
        SimpleQueue<Coordinates> queue = new SimpleQueue<>();

    }
}
