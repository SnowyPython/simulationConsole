package ru.snowypython.entity;

import ru.snowypython.Coordinates;

public class Herbivore extends Creature {
    public static final Character icon = 'H';

    public Herbivore(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void makeMove() {

    }
}
