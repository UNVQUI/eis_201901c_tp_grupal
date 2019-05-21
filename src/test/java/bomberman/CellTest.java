package bomberman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {
    Cell cell;
    Bomberman bomberman;
    Wall wall;
    Enemy enemy;

    @Before
    public void setUp(){
        cell = new Cell();
        bomberman = new Bomberman();
        wall = new Wall();
        enemy = new Enemy();
    }

    @Test
    public void anEmptyCellShouldNotHaveAnyEntity() {
        assertFalse(cell.has(bomberman));
        assertFalse(cell.has(wall));
        assertFalse(cell.has(enemy));
    }

    @Test
    public void puttingBombermanInAnEmptyCellThenShouldHaveIt() {
        cell.put(bomberman);
        assertTrue(cell.has(bomberman));
    }

    @Test
    public void movingBombermanInAnCellWithAWallShouldNotMoveIt() {
        cell.put(wall);
        bomberman.moveTo(cell);
        assertFalse(cell.has(bomberman));
    }
}