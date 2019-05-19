package gradle.cucumber;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class BasicStepdefs {
    private Bomberman bomberman = new Bomberman();
    private Cell emptyCell = new Cell();
    private Cell cellWithWall = new Cell(CellContent.WALL);
    private Cell cellWithEnemy = new Cell(CellContent.ENEMY);

    @When("^Bomberman moves to an empty cell")
    public void bombermanMovesToEmptyCell(){
        bomberman.moveTo(emptyCell);
    }

    @Then("^Bomberman changes its position")
    public void bombermanChangesItsPosition(){
        Assert.assertTrue(bomberman.isAtCell(emptyCell));
    }

    @When("^Bomberman moves to a cell that has a wall")
    public void bombermanMovesToCellWithWall(){
        bomberman.moveTo(cellWithWall);
    }

    @Then("^Bomberman doesn't change its position")
    public void bombermanStaysInPosition(){
        Assert.assertFalse(bomberman.isAtCell(cellWithWall));
    }


    @When("^Bomberman moves to a cell with an enemy")
    public void bombermanMovesToCellWithAnEnemy(){
        bomberman.moveTo(cellWithEnemy);
    }

    @Then("^Bomberman dies")
    public void bombermanDies(){
        Assert.assertTrue(bomberman.isDead());
    }



}
