package Bomberman;

public class Bomberman {
    private Coordinate coordinate = new Coordinate(1,1);
    public void move(Direction direction) {
        direction.moveCoordinate(this.coordinate);
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }
}
