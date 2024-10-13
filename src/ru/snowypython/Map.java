package ru.snowypython;

import ru.snowypython.entity.*;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> map = new HashMap<>();

    public void setEntity(Entity entity, Coordinates coordinates) {
        entity.coordinates = coordinates;
        map.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public void replaceEntity(Entity entity, Coordinates oldCoordinates, Coordinates newCoordinates) {
        entity.coordinates = newCoordinates;
        map.remove(oldCoordinates, entity);
        map.put(newCoordinates, entity);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public boolean isSquareGrass(Coordinates coordinates) {
        return map.get(coordinates) instanceof Grass;
    }

    public boolean isSquareRock(Coordinates coordinates) {
        return  map.get(coordinates) instanceof Rock;
    }

    public boolean isSquareTree(Coordinates coordinates) {
        return map.get(coordinates) instanceof Tree;
    }

    public boolean isSquarePredator(Coordinates coordinates) {
        return map.get(coordinates) instanceof Predator;
    }

    public boolean isSquareHerbivore(Coordinates coordinates) {
        return map.get(coordinates) instanceof Herbivore;
    }
}
