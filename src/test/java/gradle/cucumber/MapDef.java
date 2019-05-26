package gradle.cucumber;

import bomberman.*;
import bomberman.errors.CellEntityNotFound;
import cucumber.api.java8.En;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapDef implements En {
    GameMap gameMap;
    Bomberman bomberman;
    Bomb bomb;
    Map<String, CellEntity> entities = new HashMap<>();

    public MapDef() {
        Given("^Initial map$", () -> {
            gameMap = new GameMap();
            bomberman = new Bomberman();
            gameMap.getCellAt(new Position(0, 0)).put(bomberman);
        });
        And("Bomberman drops Bomb at-{int},{int}-", (Integer x, Integer y) -> {
            bomberman.moveTo(gameMap.getEntityCell(bomberman), gameMap.getCellAt(new Position(x, y)));
            bomb = bomberman.dropBomb(gameMap.getEntityCell(bomberman));
        });
        And("place {word} at-{int},{int}- as {string}", (String thing, Integer x, Integer y, String entityPointer) -> {
            CellEntity entity = getCellEntityFromString(thing);
            entities.put(entityPointer, entity);
            gameMap.getCellAt(new Position(x, y)).put(entity);
        });
        When("^Time passes and Bomb explodes$", () -> {
            bomb.tick(gameMap.getEntityCell(bomb));
            bomb.tick(gameMap.getEntityCell(bomb));
            bomb.tick(gameMap.getEntityCell(bomb)); //BOOM
        });
        When("time passes for {word} and explodes", (String entityPointer) -> {
            Bomb entityBomb = (Bomb)entities.get(entityPointer);
            Cell cell = gameMap.getEntityCell(entityBomb);
            entityBomb.tick(cell);
            entityBomb.tick(cell);
            entityBomb.tick(cell); //BOOM
        });
        Then("{string} is destroyed", this::testEntityNotInMap);
        Then("{string} is dead", this::testEntityNotInMap);

        Then("{string} is not destroyed", (String entityPointer) ->
                gameMap.getEntityCell(entities.get(entityPointer)));
        When("Bomberman moves to-{int},{int}-", (Integer x, Integer y) ->
                bomberman.moveTo(gameMap.getEntityCell(bomberman), gameMap.getCellAt(new Position(x, y))));
        Then("Bomberman has {word}", (String thing) ->
                assertTrue(bomberman.hasPower(getCellEntityFromString(thing))));
        And("Bomberman gets {word}", (String thing) ->
                bomberman.getPower(getCellEntityFromString(thing)));
        When("Bomberman throws Bomb to {word} -{int}- cells away as {word}",
                (String direction, Integer distance, String entityPointer) -> {
            bomb = bomberman.dropBomb(gameMap.getEntityCell(bomberman), Direction.valueOf(direction), distance);
            entities.put(entityPointer, bomb);
        });
        And("other throws Bomb {word} -{int}- cells away as {word}",
                (String direction, Integer distance, String entityPointer) -> {
                    Bomb bomb = bomberman.dropBomb(gameMap.getEntityCell(bomberman), Direction.valueOf(direction), distance);
                    entities.put(entityPointer, bomb);
                });
        When("Bomberman jump to {word}", (String direction) -> {
            bomberman.jumpTo(gameMap.getEntityCell(bomberman), Direction.valueOf(direction));
        });
        Then("Bomberman is at-{int},{int}-", (Integer x, Integer y) -> {
            assertEquals(new Position(x, y),gameMap.getPositionFrom(bomberman));
        });
    }

    public void testEntityNotInMap(String entityPointer) {
        assertThrows(CellEntityNotFound.class, () -> gameMap.getEntityCell(entities.get(entityPointer)));
    }

    private CellEntity getCellEntityFromString(String type){
        if(type.equals("Enemy")) return new Enemy();
        if(type.equals("MelaninWall")) return new MelaninWall();
        if(type.equals("SteelWall")) return new SteelWall();
        if(type.equals("Bagulaa")) return new Bagulaa();
        if(type.equals("BagulaaPower")) return new BagulaaPower();
        if(type.equals("ProtoMaxJr")) return new ProtoMaxJr();
        if(type.equals("ProtoMaxJrPower")) return new ProtoMaxJrPower();
        if(type.equals("ProtoMaxUnits")) return new ProtoMaxUnits();
        if(type.equals("ProtoMaxUnitsPower")) return new ProtoMaxUnitsPower();
        throw new RuntimeException(type + " Entity not defined in step definition");
    }
}
