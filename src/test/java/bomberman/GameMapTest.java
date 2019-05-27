package bomberman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameMapTest {
    private GameMap map;

    @Before
    public void setUp() {
        map = new GameMap();
    }

    @Test
    public void cellAtPos00HasCellAtPos10OnItsRight() {
        assertEquals(map.getCellAt(new Position(1, 0)), map.getCellAt(new Position(0, 0)).cellAt(Direction.RIGHT));
    }

    @Test
    public void cellAtPos10HasCellAtPos00OnItsLeft() {
        assertEquals(map.getCellAt(new Position(0, 0)), map.getCellAt(new Position(1, 0)).cellAt(Direction.LEFT));
    }

    @Test
    public void cellAtPos00HasSameCellMakingARide() {
        Cell cell00 = map.getCellAt(new Position(0, 0));
        Cell actual = cell00
                .cellAt(Direction.RIGHT)
                .cellAt(Direction.DOWN)
                .cellAt(Direction.LEFT)
                .cellAt(Direction.UP);
        assertEquals(cell00, actual);
    }
}