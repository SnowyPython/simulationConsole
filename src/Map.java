import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> map = new HashMap<>();

    public void setEntity(Coordinates coordinates, Entity entity) {
        map.put(coordinates, entity);
    }
}
