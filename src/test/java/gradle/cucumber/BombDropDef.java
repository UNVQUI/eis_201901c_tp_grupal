package gradle.cucumber;

import bomberman.Bomb;
import bomberman.Bomberman;
import bomberman.Cell;
import bomberman.Enemy;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


public class BombDropDef {

    Bomberman bomberman = new Bomberman();
    Bomb bomb = new Bomb(3);

    @Given ("Droped bomb in a cell")
    public void DropedBombInACell{
        bomberman.dropBomb(bomb);
    }

    @When("Bomb explotes after 3 ticks")
    public void BombExplotesAfter3Ticks{

        for(int i=0;i<3;i++){bomb.tick();}
       // assertFalse(bomberman.getActualCell().getEntities().contains(bomb));
    }

    @Then("Enemy is dead")
    public void EnemyIsDead{

        assertTrue( (Enemy) bomb.getActualCell().getEntities()
                .stream()
                .filter(x -> Enemy.class.isAssignableFrom(x.getClass()))
                .findAny().orElse(null)
                .isAlive());
    }


}
