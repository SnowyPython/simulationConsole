package ru.snowypython.entity;

import ru.snowypython.Coordinates;

public class Grass extends Entity {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String icon = ANSI_GREEN + 'G' + ANSI_RESET;

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }
}
