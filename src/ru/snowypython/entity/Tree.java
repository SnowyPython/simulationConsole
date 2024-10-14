package ru.snowypython.entity;

import ru.snowypython.Coordinates;

public class Tree extends Entity {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static final String icon = ANSI_BLACK + 'T' + ANSI_RESET;

    public Tree(Coordinates coordinates) {
        super(coordinates);
    }
}
