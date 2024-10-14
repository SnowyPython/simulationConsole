package ru.snowypython.entity;

import ru.snowypython.Coordinates;
import ru.snowypython.Map;

public abstract class Creature extends Entity {
    private int speed;
    private int hp;
    private boolean death;

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    public abstract int getSpeed();
    public abstract int getHp();
    public abstract boolean isDeath();
    public abstract void setDeath();

    public abstract void makeMove(Map map, Coordinates coordinates);
}
