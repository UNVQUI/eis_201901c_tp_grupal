package gradle.cucumber;

import bomberman.*;
import bomberman.errors.CellEntityNotFound;
import cucumber.api.java8.En;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapDef implements En {
    GameMap gameMap;
    Bomberman bomberman;
    Bomb bomb;
    Map<String, CellEntity> entities = new HashMap<>();

    public MapDef() {
        Given("^Initial map$", () -> {
            gameMap = new GameMap();
            bomberman = new Bomberman(gameMap.getCellAt(new Position(0,0)));
        });
        And("^Bomberman drops Bomb at-(\\d+),(\\d+)-$", (Integer x, Integer y) -> {
            bomberman.moveTo(gameMap.getCellAt(new Position(x, y)));
            bomb = bomberman.dropBomb();
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
        Then("{string} is destroyed", this::testEntityNotInMap);
        Then("{string} is dead", this::testEntityNotInMap);

        Then("{string} is not destroyed", (String entityPointer) -> {
            gameMap.getEntityCell(entities.get(entityPointer));
        });

    }

    public void testEntityNotInMap(String entityPointer) {
        assertThrows(CellEntityNotFound.class, () -> gameMap.getEntityCell(entities.get(entityPointer)));
    }

    private CellEntity getCellEntityFromString(String type){
        if(type.equals("Enemy")) return new Enemy();
        if(type.equals("MelaninWall")) return new MelaninWall();
        if(type.equals("SteelWall")) return new SteelWall();
        throw new RuntimeException(type + " Entity not defined in step definition");
    }
}
