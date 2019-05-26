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
        bomberman = new Bomberman(map.getCellAt(new Position(0, 0)));
        power = new ProtoMaxUnitsPower();
    }

    @Test
    public void bombermanGetsProtoMaxUnitsPowerJumpToRightAndLandsOnCell_2_0() {
        bomberman.getPower(power);
        map.getCellAt(new Position(1, 0)).put(new Wall());
        bomberman.jumpTo(Direction.RIGHT);

        Position newPos = new Position(2, 0);
        Position expectedPos = map.getPositionFrom(bomberman);
        assertEquals(newPos, expectedPos);
    }

    @Test
    public void bombermanGetsProtoMaxUnitsPowerAndThrowsABombTwoCellsToRight() {
        bomberman.getPower(power);
        Bomb bomb = bomberman.dropBomb(Direction.RIGHT, 2);

        Position newPos = new Position(2, 0);
        Position expectedPos = map.getPositionFrom(map.getEntityCell(bomb));
        assertEquals(newPos, expectedPos);
    }

    @Test(expected = PowerNotFound.class)
    public void bombermanJumpsToRightButHeDoesNotHaveProtoMaxUnitsPower() {
        bomberman.jumpTo(Direction.RIGHT);
    }

    @Test(expected = PowerNotFound.class)
    public void bombermanThrowsABombTwoCellsToRightButHeDoesNotHaveProtoMaxUnitsPower() {
        bomberman.dropBomb(Direction.RIGHT, 2);
    }
}
