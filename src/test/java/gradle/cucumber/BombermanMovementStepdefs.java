package gradle.cucumber;

import bomberman.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class BombermanMovementStepdefs {
    Bomberman bomberman = new Bomberman();
    Cell actualCell = new Cell();
    Cell contingentCell = new Cell();

    @Given("Empty contingent cell")
    public void EmptyContingentCell() {}

    @When("Bomberman moves to contingent cell")
    public void BombermanMovesToContingentCell() {
        bomberman.moveTo(actualCell, contingentCell);
    }

    @Then("Bomberman has moved to contingent cell")
    public void bombermanHasMovedToContingentCell() {
        assertTrue(bomberman.isIn(contingentCell));
    }

    @Given("Wall in contingent cell")
    public void wallInContingentCell() {
        contingentCell.put(new SteelWall());
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