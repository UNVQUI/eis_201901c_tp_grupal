package bomberman;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<CellEntity> entityList = new ArrayList<CellEntity>();
    private GameMap map;

    public Cell() {}

    public Cell(GameMap map) {
        this.map = map;
    }

    public void put(CellEntity entity) {
        entityList.add(entity);
    }

    public boolean has(CellEntity entity) {
        return entityList.contains(entity);
    }

    public void moveToHere(Cell origin, Bomberman bomberman) {
        if (entityList.stream().anyMatch(CellEntity::blocksMovement)) return;
        origin.remove(bomberman);
        this.put(bomberman);
        entityList.forEach(entity -> entity.interactWith(bomberman));
    }

    private void remove(CellEntity entity) {
        entityList.remove(entity);
    }

    public Cell cellAt(Direction direction) {
        return map.getCellAt(new Position(1, 0));
    }
}
