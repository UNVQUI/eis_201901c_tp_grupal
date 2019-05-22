package bomberman;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private Map<Position, Cell> map = new HashMap<>();

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
}
