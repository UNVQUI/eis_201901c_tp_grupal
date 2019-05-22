package gradle.cucumber;

import bomberman.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.*;


public class BombDropDef {

    Bomberman bomberman = new Bomberman();
    Bomb bomb = new Bomb(3);
    Cell cell = bomberman.getActualCell();

    @Given ("Droped bomb in a cell")
    public void DropedBombInACell(){
        bomberman.dropBomb(bomb);
    }

    @When("Bomb explotes after 3 ticks")
    public void BombExplotesAfter3Ticks(){

        for(int i=0;i<3;i++){bomb.tick();}
       // assertFalse(bomberman.getActualCell().getEntities().contains(bomb));
    }

    @Then("Enemy is dead")
    public void EnemyIsDead(){

        CellEntity actual = cell.getEntities()
                .stream()
                .filter(x -> x instanceof Enemy)
                .findAny().orElse(null);

        assertFalse(((Enemy) actual).isAlive());
    }


}
