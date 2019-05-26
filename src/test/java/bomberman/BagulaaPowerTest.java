package bomberman;

import bomberman.errors.PowerNotFound;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BagulaaPowerTest {
    private Power power;
    private Bomberman bomberman;
    private GameMap map;

    @Before
    public void setUp() {
        map = new GameMap();
        bomberman = new Bomberman();
        map.getCellAt(new Position(0, 0)).put(bomberman);
        power = new BagulaaPower();
    }

    @Test
    public void bombermanGetsBagulaaPowerAndThrowsABombTwoCellsToRight() {
        bomberman.getPower(power);
        Bomb bomb = bomberman.dropBomb(map.getEntityCell(bomberman), Direction.RIGHT, 2);

        Position newPos = new Position(2, 0);
        Position expectedPos = map.getPositionFrom(map.getEntityCell(bomb));
        assertEquals(newPos, expectedPos);
    }

    @Test(expected = PowerNotFound.class)
    public void bombermanThrowsABombTwoCellsToRightButHeDoesNotHaveBagulaaPower() {
        bomberman.dropBomb(map.getEntityCell(bomberman), Direction.RIGHT, 2);
    }
}