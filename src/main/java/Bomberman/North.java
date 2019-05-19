package Bomberman;

public class North extends Direction {
    public void moveCoordinate(Coordinate coordinate) {
        coordinate.incrementY();
    }
}
