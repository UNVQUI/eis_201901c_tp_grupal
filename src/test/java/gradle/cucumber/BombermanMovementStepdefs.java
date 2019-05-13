package gradle.cucumber;

import bomberman.Bomberman;
import bomberman.Cell;
import bomberman.Enemy;
import bomberman.Wall;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class BombermanMovementStepdefs {
    Bomberman bomberman = new Bomberman();
    Cell contingentCell = new Cell();

    @Given("Empty contingent cell")
    public void EmptyContingentCell() {}

    @When("Bomberman moves to contingent cell")
    public void BombermanMovesToContingentCell() {
        bomberman.moveTo(contingentCell);
    }

    @Then("Bomberman has moved to contingent cell")
    public void bombermanHasMovedToContingentCell() {
        assertTrue(bomberman.isIn(contingentCell));
    }

    @Given("Wall in contingent cell")
    public void wallInContingentCell() {
        contingentCell.put(new Wall());
    }

    @Then("Bomberman has not moved to contingent cell")
    public void bombermanHasNotMovedToContingentCell() {
        assertFalse(bomberman.isIn(contingentCell));
    }

    @Given("Enemy in contingent cell")
    public void enemyInContingentCell() {
        contingentCell.put(new Enemy());
    }

    @Then("Bomberman is dead")
    public void bombermanIsDead() {
        assertFalse(bomberman.isAlive());
    }
}