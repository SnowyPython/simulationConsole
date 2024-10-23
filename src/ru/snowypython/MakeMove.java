package ru.snowypython;

import ru.snowypython.entity.Creature;
import ru.snowypython.entity.Entity;

import java.util.HashSet;
import java.util.Set;

public class MakeMove extends Actions {
    public static void makeMove(Map map) {
        Set<Creature> creaturesToMove = new HashSet<>();

        for (Coordinates key : map.getCoordinates()) {
            Entity entity = map.getEntity(key);
            if (entity instanceof Creature creature) {
                creaturesToMove.add(creature);
            }
        }

        for (Creature creature : creaturesToMove) {
            creature.makeMove(map, creature.coordinates);
        }
    }
}
