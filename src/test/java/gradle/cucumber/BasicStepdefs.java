package gradle.cucumber;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class BasicStepdefs {
    private Bomberman bomberman = new Bomberman();
    private Cell emptyCell = new Cell();
    private Cell cellWithWall = new Cell(true);

    @When("^the cell is empty")
    public void bombermanMovesToEmptyCell(){
        bomberman.moveTo(emptyCell);
    }

    @Then("^Bomberman changes its position")
    public void bombermanChangesItsPosition(){
        Assert.assertTrue(bomberman.isAtCell(emptyCell));
    }

    @When("^the cell has a wall")
    public void bombermanMovesToCellWithWall(){
        bomberman.moveTo(cellWithWall);
    }

    @Then("^Bomberman doesn't change its position")
    public void bombermanStaysInPosition(){
        Assert.assertFalse(bomberman.isAtCell(cellWithWall));
    }

}
