package bomberman;

import bomberman.errors.CellEntityNotFound;
import bomberman.errors.CellNotFound;
import com.google.common.collect.HashBiMap;

public class GameMap {
    private HashBiMap<Position, Cell> map = HashBiMap.create();

    public GameMap() {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                map.put(new Position(x, y), new Cell(this));
            }
        }
    }

    public Cell getCellAt(Position position) {
        if (map.containsKey(position)) return map.get(position);
        throw new CellNotFound();
    }

    public Position getPositionFrom(Cell cell) {
        return map.inverse().get(cell);
    }

    public Cell getEntityCell(CellEntity entity) {
        return map.values().stream()
                .filter(cell -> cell.has(entity))
                .findFirst()
                .orElseThrow(CellEntityNotFound::new);
    }
}
