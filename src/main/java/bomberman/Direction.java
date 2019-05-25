package bomberman;

public enum Direction {
    RIGHT(new Position(1, 0)),
    LEFT(new Position(-1, 0)),
    UP(new Position(0, -1)),
    DOWN(new Position(0, 1));

    private Position position;

    Direction(Position position){
        this.position = position;
    }

    public Position add(Position position) {
        return position.add(this.position);
    }
}
