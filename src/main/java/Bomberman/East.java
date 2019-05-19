package Bomberman;

public class East extends Direction {
    @Override
    public void moveCoordinate(Coordinate coordinate) {
        coordinate.incrementX();
    }
}
