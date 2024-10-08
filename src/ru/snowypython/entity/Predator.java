package ru.snowypython.entity;

import ru.snowypython.Coordinates;

public class Predator extends Creature {
    public static final Character icon = 'P';

    private int power;

    public Predator(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void makeMove() {

    }
}
