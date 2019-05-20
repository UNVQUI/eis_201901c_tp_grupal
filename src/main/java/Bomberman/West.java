package Bomberman;

public class West extends Direction {
    @Override
    public void moveCoordinate(Coordinate coordinate) {
        coordinate.decrementX();
    }

    @Override
    public Coordinate giveNextCoordinate(Coordinate coordinate){
        Coordinate newCoordinate = coordinate;
        newCoordinate.decrementX();
        return newCoordinate;
    }
}
