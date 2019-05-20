package Bomberman;

public class East extends Direction {
    @Override
    public void moveCoordinate(Coordinate coordinate) {
        coordinate.incrementX();
    }

    @Override
    public Coordinate giveNextCoordinate(Coordinate coordinate){
        Coordinate newCoordinate = coordinate;
        newCoordinate.incrementX();
        return newCoordinate;
    }
}
