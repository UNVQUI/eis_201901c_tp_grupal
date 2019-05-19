package gradle.cucumber;

public class Cell {
    public CellContent content;
    final int x;
    final int y;

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
        this.content = CellContent.EMPTY;
    }
}

enum CellContent{
    EMPTY,
    WALL,
    ENEMY
}
