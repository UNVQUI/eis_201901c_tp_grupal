package gradle.cucumber;

import java.util.ArrayList;
import java.util.List;

public class BombermanGrid {
    private final int width;
    private final int length;
    private List<Cell> cells = new ArrayList<>();

    public BombermanGrid(int horizontalSize, int verticalSize){
        this.width = horizontalSize;
        this.length = verticalSize;
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    public void bombDropped(Cell location) {
        cells.stream().filter(cell -> Math.abs(cell.x - location.x)<=3 || Math.abs(cell.y - location.y)<=3).forEach(Cell::empty);
    }
}
