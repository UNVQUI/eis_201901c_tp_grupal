package bomberman;

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
        return map.get(position);
    }

    public Position getPositionFrom(Cell cell) {
        return map.inverse().get(cell);
    }
}
