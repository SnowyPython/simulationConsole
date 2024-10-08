package ru.snowypython.entity;

import ru.snowypython.Coordinates;

public abstract class Creature extends Entity {
    private int speed;
    private int hp;

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    public abstract void makeMove();
}
