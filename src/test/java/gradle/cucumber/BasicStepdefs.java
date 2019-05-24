package gradle.cucumber;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    @When("^Bomberman drops a bomb")
    public void bombermanDropsBomb(){
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
    @When("^Bomberman is at (\\d+) cell distance to a melanin wall")
    public void bombermanDropsBombNearMelaninWall(int distance){
        int bombermanLocation = 5;

        cellLeft = new Cell(CellContent.WALL, bombermanLocation-distance, 5);
        cellRight = new Cell(CellContent.WALL, bombermanLocation+distance, 5);
        cellUp = new Cell(CellContent.WALL, 5, bombermanLocation+distance);
        cellDown = new Cell(CellContent.WALL, 5, bombermanLocation-distance);
    }

    @When("^Bomberman is at (\\d+) cell distance to an enemy")
    public void bombermanDropsBombNearEnemy(int distance){
        int bombermanLocation = 5;

        cellLeft = new Cell(CellContent.ENEMY, bombermanLocation-distance, 5, new Enemy());
        cellRight = new Cell(CellContent.ENEMY, bombermanLocation+distance, 5, new Enemy());
        cellUp = new Cell(CellContent.ENEMY, 5, bombermanLocation+distance, new Enemy());
        cellDown = new Cell(CellContent.ENEMY, 5, bombermanLocation-distance, new Enemy());
    }

    @When("^Bomberman is at (\\d+) cell distance to a steel wall")
    public void bombermanDropsBombNearSteelWall(int distance){
        int bombermanLocation = 5;

        cellLeft = new Cell(CellContent.STEEL_WALL, bombermanLocation-distance, 5);
        cellRight = new Cell(CellContent.STEEL_WALL, bombermanLocation+distance, 5);
        cellUp = new Cell(CellContent.STEEL_WALL, 5, bombermanLocation+distance);
        cellDown = new Cell(CellContent.STEEL_WALL, 5, bombermanLocation-distance);
    }

    @Then("^The wall is destroyed")
    public void surroundingWallsDestroyed(){
        Assert.assertTrue(cellLeft.isEmpty());
        Assert.assertTrue(cellRight.isEmpty());
        Assert.assertTrue(cellUp.isEmpty());
        Assert.assertTrue(cellDown.isEmpty());
    }

    @Then("^The wall is not destroyed")
    public void surroundingWallsNotDestroyed(){
        Assert.assertFalse(cellLeft.isEmpty());
        Assert.assertFalse(cellRight.isEmpty());
        Assert.assertFalse(cellUp.isEmpty());
        Assert.assertFalse(cellDown.isEmpty());
    }

    @Then("^The enemy is killed")
    public void surroundingEnemiesKilled(){
        Assert.assertTrue(cellLeft.enemy.isDead());
        Assert.assertTrue(cellRight.enemy.isDead());
        Assert.assertTrue(cellUp.enemy.isDead());
        Assert.assertTrue(cellDown.enemy.isDead());
    }

    @Then("^The enemy is not killed")
    public void surroundingEnemiesNotKilled(){
        Assert.assertFalse(cellLeft.enemy.isDead());
        Assert.assertFalse(cellRight.enemy.isDead());
        Assert.assertFalse(cellUp.enemy.isDead());
        Assert.assertFalse(cellDown.enemy.isDead());
    }

    @When("^Proto Max Jr is at (\\d+) cell distance to Bomberman")
    public void protoMaxJrNearBomberman(int distance){
        int bombermanLocation = 5;

        cellLeft = new Cell(CellContent.ENEMY, bombermanLocation-distance, bombermanLocation, new ProtoMaxJr());
        cellRight = new Cell(CellContent.ENEMY, bombermanLocation+distance, bombermanLocation, new ProtoMaxJr());
        cellUp = new Cell(CellContent.ENEMY, bombermanLocation, bombermanLocation+distance, new ProtoMaxJr());
        cellDown = new Cell(CellContent.ENEMY, bombermanLocation, bombermanLocation-distance, new ProtoMaxJr());
    }

    @Then("^Proto Max Jr deads")
    public void protoMaxJrIsDead(){
        Assert.assertTrue(cellLeft.enemy.isDead());
        Assert.assertTrue(cellRight.enemy.isDead());
        Assert.assertTrue(cellUp.enemy.isDead());
        Assert.assertTrue(cellDown.enemy.isDead());
    }

    @Then("^Proto Max Jr is alive")
    public void protoMaxJrIsAlive(){
        Assert.assertTrue(!cellLeft.enemy.isDead() || !cellRight.enemy.isDead() || !cellDown.enemy.isDead() || !cellUp.enemy.isDead() );
    }

    @Then("^Bomberman can jump walls")
    public void canJumpWalls(){
        Assert.assertTrue(bomberman.canJumpWalls);
    }


    @Then("^Bomberman cant jump walls")
    public void cantJumpWalls() {
        Assert.assertTrue(!bomberman.canJumpWalls);
    }

    @When("^Bagulaa is at (\\d+) cell distance to Bomberman")
    public void bagulaaNearBomberman(int distance){
        int bombermanLocation = 5;

        cellLeft = new Cell(CellContent.ENEMY, bombermanLocation-distance, bombermanLocation, new Bagulaa());
        cellRight = new Cell(CellContent.ENEMY, bombermanLocation+distance, bombermanLocation, new Bagulaa());
        cellUp = new Cell(CellContent.ENEMY, bombermanLocation, bombermanLocation+distance, new Bagulaa());
        cellDown = new Cell(CellContent.ENEMY, bombermanLocation, bombermanLocation-distance, new Bagulaa());
    }

    @Then("^Bagulaa deads")
    public void bagulaaIsDead(){
        Assert.assertTrue(cellLeft.enemy.isDead());
        Assert.assertTrue(cellRight.enemy.isDead());
        Assert.assertTrue(cellUp.enemy.isDead());
        Assert.assertTrue(cellDown.enemy.isDead());
    }

    @Then("^Bomberman activate superBomb")
    public void activateSuperBombAndBombRadiousIs5(){
        BombermanGrid grid = new BombermanGrid(10, 10);
        grid.setSuperBombRadious(5);
        int radious = grid.getSuperBombRadious();
        Assert.assertTrue(bomberman.activateSuperBomb);
        Assert.assertEquals(5, radious);
    }
}
