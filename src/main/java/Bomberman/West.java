package Bomberman;

public class West extends Direction {
    @Override
    public void moveCoordinate(Coordinate coordinate) {
        coordinate.decrementX();
    }
}
