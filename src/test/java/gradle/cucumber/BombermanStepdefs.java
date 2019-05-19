package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Bomberman.Bomberman;
import Bomberman.Coordinate;
import Bomberman.North;

import static org.assertj.core.api.Assertions.assertThat;

public class BombermanStepdefs {
    private Bomberman bomberman;

    @Given("^Bomberman")
    public void newBomberman()  {
        bomberman = new Bomberman();
    }

    @When("^Lo muevo de celda hacia el norte")
    public void moveToNorthenCell() {
        bomberman.move(new North());
    }

    @Then("^bomberman esta en la proxima celda al norte")
    public void getCoordinate() {
        Coordinate actual = bomberman.getCoordinate();
        Coordinate expected = new Coordinate(1,2);

        assertThat(actual).isEqualTo(expected);
    }
}
