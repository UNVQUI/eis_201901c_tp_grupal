package Bomberman;

public class South extends Direction {
    @Override
    public void moveCoordinate(Coordinate coordinate) {
        coordinate.decrementY();
    }
}
