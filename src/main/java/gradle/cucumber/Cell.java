package gradle.cucumber;

public class Cell {
    public final boolean hasWall;

    public Cell() {
        this(false);
    }

    public Cell(boolean hasWall) {
        this.hasWall = hasWall;
    }
}
