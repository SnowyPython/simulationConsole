public class Simulation {
    public static void main(String[] args) {
        Map map = new Map();

        map.setEntity(new Coordinates(File.A, 1), new Grass());
        map.setEntity(new Coordinates(File.B, 4), new Grass());

        MapRenderer.render(map);
    }
}
