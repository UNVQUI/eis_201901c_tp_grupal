package gradle.cucumber;

public class Bomberman {
    private Cell location;

    public void moveTo(Cell cell) {
        if (!cell.hasWall)
            this.location = cell;
    }

    public boolean isAtCell(Cell cell) {
        return cell == location;
    }
}
