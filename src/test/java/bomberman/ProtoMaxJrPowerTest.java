package bomberman;

import bomberman.errors.PowerNotFound;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProtoMaxJrPowerTest {
    private Power power;
    private Bomberman bomberman;
    private GameMap map;

    @Before
    public void setUp() {
        map = new GameMap();
        bomberman = new Bomberman(map.getCellAt(new Position(0, 0)));
        power = new ProtoMaxJrPower();
    }

    @Test
    public void bombermanGetsProtoMaxJrPowerJumpToRightAndLandsOnCell_2_0() {
        bomberman.getPower(power);
        map.getCellAt(new Position(1, 0)).put(new Wall());
        bomberman.jumpTo(Direction.RIGHT);

        Position newPos = new Position(2, 0);
        Position expectedPos = map.getPositionFrom(bomberman);
        assertEquals(newPos, expectedPos);
    }

    @Test(expected = PowerNotFound.class)
    public void bombermanJumpsToRightButHeDoesNotHaveProtoMaxJrPower() {
        bomberman.jumpTo(Direction.RIGHT);
    }
}
