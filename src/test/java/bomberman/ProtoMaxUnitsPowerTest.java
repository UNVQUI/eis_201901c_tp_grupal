package bomberman;

import bomberman.errors.PowerNotFound;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

    @Test
    public void bombermanGetsProtoMaxUnitsPowerAndThrow2BombsTwoAndTreeCellsToRight() {
        bomberman.getPower(power);
        Bomb bomb1 = bomberman.dropBomb(map.getEntityCell(bomberman), Direction.RIGHT, 2);
        Bomb bomb2 = bomberman.dropBomb(map.getEntityCell(bomberman), Direction.RIGHT, 3);

        Position expectedPos1 = new Position(2, 0);
        Position expectedPos2 = new Position(3, 0);
        Position actualPos1 = map.getPositionFrom(map.getEntityCell(bomb1));
        Position actualPos2 = map.getPositionFrom(map.getEntityCell(bomb2));
        assertEquals(expectedPos1, actualPos1);
        assertEquals(expectedPos2, actualPos2);
    }

    @Test
    public void bombermanThrow2BombsTwoAndTreeCellsToRightAndKillTwoEnemys() {
        bomberman.getPower(power);

        Enemy enemy1 = new Enemy();
        Enemy enemy2 = new Enemy();
        map.getCellAt(new Position(2, 1)).put(enemy1);
        map.getCellAt(new Position(3, 1)).put(enemy2);

        assertEquals(new Position(2, 1), map.getPositionFrom(map.getEntityCell(enemy1)));
        assertEquals(new Position(3, 1), map.getPositionFrom(map.getEntityCell(enemy2)));

        Bomb bomb1 = bomberman.dropBomb(map.getEntityCell(bomberman), Direction.RIGHT, 2);
        Bomb bomb2 = bomberman.dropBomb(map.getEntityCell(bomberman), Direction.RIGHT, 3);

        bomb1.tick(map.getEntityCell(bomb1));
        bomb1.tick(map.getEntityCell(bomb1));
        bomb1.tick(map.getEntityCell(bomb1)); //BOOM
        bomb2.tick(map.getEntityCell(bomb2));
        bomb2.tick(map.getEntityCell(bomb2));
        bomb2.tick(map.getEntityCell(bomb2)); //BOOM

        assertFalse(map.getCellAt(new Position(2, 1)).getEntities().contains(enemy1));
        assertFalse(map.getCellAt(new Position(2, 1)).getEntities().contains(enemy2));
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
