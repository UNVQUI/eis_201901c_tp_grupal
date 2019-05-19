package gradle.cucumber;

public class Cell {
    public CellContent content;
    final int x;
    final int y;
    Enemy enemy;

    public Cell() {
        this(CellContent.EMPTY, 0, 0);
    }

    public Cell(CellContent content) {
        this(content, 0, 0);
    }

    public Cell(CellContent content, int xLocation, int yLocation) {
        this.content = content;
        this.x = xLocation;
        this.y = yLocation;
    }

    public Cell(CellContent content, int xLocation, int yLocation, Enemy enemy) {
        this(content, xLocation, yLocation);
        this.enemy = enemy;
    }

    public void locateBomberman(Bomberman bomberman) {
        if (this.isEmpty())
            bomberman.location = this;
        if (this.hasEnemy())
            bomberman.die();
    }

    private boolean hasEnemy() {
        return this.content == CellContent.ENEMY;
    }

    boolean isEmpty(){
        return this.content == CellContent.EMPTY;
    }

    public void empty() {
        if (!hasSteelWall()) {
            if (hasEnemy())
                this.enemy.kill();
            this.content = CellContent.EMPTY;
        }
    }

    private boolean hasSteelWall() {
        return this.content == CellContent.STEEL_WALL;
    }
}

enum CellContent{
    EMPTY,
    WALL,
    ENEMY,
    STEEL_WALL
}
