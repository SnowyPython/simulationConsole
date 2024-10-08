package ru.snowypython.entity;

import ru.snowypython.Coordinates;

public class Rock extends Entity {
    public static final Character icon = 'R';

    public Rock(Coordinates coordinates) {
        super(coordinates);
    }
}
