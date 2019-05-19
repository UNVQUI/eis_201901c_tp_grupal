package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class BasicStepdefs {
    private Bomberman bomberman = new Bomberman();
    private Cell emptyCell = new Cell();
    private Cell cellWithWall = new Cell(CellContent.WALL);
    private Cell cellWithEnemy = new Cell(CellContent.ENEMY);


    private Cell cellLeft;
    private Cell cellRight;
    private Cell cellUp;
    private Cell cellDown;

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

    @When("^Bomberman drops a bomb at (\\d+) cell distance to a melanin wall")
    public void bombermanDropsBombNearMelaninWall(int distance){
        int bombermanLocation = 5;

        cellLeft = new Cell(CellContent.WALL, bombermanLocation-distance, 5);
        cellRight = new Cell(CellContent.WALL, bombermanLocation+distance, 5);
        cellUp = new Cell(CellContent.WALL, 5, bombermanLocation+distance);
        cellDown = new Cell(CellContent.WALL, 5, bombermanLocation-distance);

        Cell bombermanCell = new Cell(CellContent.EMPTY, 5, 5);
        BombermanGrid grid = new BombermanGrid(10, 10);

        grid.addCell(bombermanCell);
        grid.addCell(cellLeft);
        grid.addCell(cellRight);
        grid.addCell(cellUp);
        grid.addCell(cellDown);

        bomberman.moveTo(bombermanCell);

        bomberman.dropBomb(grid);
    }

    @Then("^The wall is destroyed")
    public void surroundingWallsDestroyed(){
        Assert.assertTrue(cellLeft.isEmpty());
        Assert.assertTrue(cellRight.isEmpty());
        Assert.assertTrue(cellUp.isEmpty());
        Assert.assertTrue(cellDown.isEmpty());
    }

}
