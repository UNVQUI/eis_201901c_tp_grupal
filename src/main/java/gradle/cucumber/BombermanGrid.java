package gradle.cucumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BombermanGrid {
    private final int width;
    private final int length;
    private static final int bombRadious = 3;
    private List<Cell> cells = new ArrayList<>();

    public BombermanGrid(int horizontalSize, int verticalSize){
        this.width = horizontalSize;
        this.length = verticalSize;
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    public List<Enemy> bombDropped(Cell location) {

        List<Cell> cellsAffected = cells.stream().filter(cell ->
                isReachedByBombHorizontal(cell, location) &&
                        isReachedByBombVertical(cell, location)).collect(Collectors.toList());

        List<Enemy> enemies = cellsAffected.stream().filter(cell -> cell.enemy!=null).map(cell-> cell.enemy).collect(Collectors.toList());

        cellsAffected.forEach(Cell::empty);

        return enemies;
    }

    private boolean isReachedByBombHorizontal(Cell cell, Cell bombCell){
        return Math.abs(cell.x - bombCell.x)<=bombRadious;
    }

    private boolean isReachedByBombVertical(Cell cell, Cell bombCell){
        return Math.abs(cell.y - bombCell.y)<=bombRadious;
    }
}
