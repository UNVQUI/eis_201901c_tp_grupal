package gradle.cucumber;

public class Cell {
    public final CellContent content;

    public Cell() {
        this(CellContent.EMPTY);
    }

    public Cell(CellContent content) {
        this.content = content;
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

    private boolean isEmpty(){
        return this.content == CellContent.EMPTY;
    }
}

enum CellContent{
    EMPTY,
    WALL,
    ENEMY
}
