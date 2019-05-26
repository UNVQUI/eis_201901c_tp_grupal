package bomberman;

import bomberman.errors.PowerNotFound;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProtoMaxUnitsPowerTest {
    private Power power;
    private Bomberman bomberman;
    private GameMap map;

    @Before
    public void setUp() {
        map = new GameMap();
        bomberman = new Bomberman();
        map.getCellAt(new Position(0, 0)).put(bomberman);
        power = new ProtoMaxUnitsPower();
    }

    @Test
    public void bombermanGetsProtoMaxUnitsPowerJumpToRightAndLandsOnCell_2_0() {
        bomberman.getPower(power);
        map.getCellAt(new Position(1, 0)).put(new SteelWall());
        bomberman.jumpTo(map.getEntityCell(bomberman), Direction.RIGHT);

        Position newPos = new Position(2, 0);
        Position expectedPos = map.getPositionFrom(bomberman);
        assertEquals(newPos, expectedPos);
    }

    @Test
    public void bombermanGetsProtoMaxUnitsPowerAndThrowsABombTwoCellsToRight() {
        bomberman.getPower(power);
        Bomb bomb = bomberman.dropBomb(map.getEntityCell(bomberman), Direction.RIGHT, 2);

        Position newPos = new Position(2, 0);
        Position expectedPos = map.getPositionFrom(map.getEntityCell(bomb));
        assertEquals(newPos, expectedPos);
    }

    @Test(expected = PowerNotFound.class)
    public void bombermanJumpsToRightButHeDoesNotHaveProtoMaxUnitsPower() {
        bomberman.jumpTo(map.getEntityCell(bomberman), Direction.RIGHT);
    }

    @Test(expected = PowerNotFound.class)
    public void bombermanThrowsABombTwoCellsToRightButHeDoesNotHaveProtoMaxUnitsPower() {
        bomberman.dropBomb(map.getEntityCell(bomberman), Direction.RIGHT, 2);
    }
}
