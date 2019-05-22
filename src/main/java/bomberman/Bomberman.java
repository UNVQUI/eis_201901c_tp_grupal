package bomberman;

public class Bomberman implements CellEntity{

    private Cell actualCell = new Cell();
    private Boolean alive = true;

    public Bomberman() {
        actualCell.put(this);
    }

    public void moveTo(Cell contingentCell) {
        contingentCell.moveToHere(actualCell, this);
    }

    public boolean isIn(Cell otherCell) {
        return otherCell.has(this);
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public boolean blocksMovement() {
        return false;
    }

    @Override
    public void interactWith(CellEntity anotherEntity) {}

    public void kill() {
        this.alive = false;
    }

    public void dropBomb(Bomb bomb){
        actualCell.put(bomb);
    }

    public Cell getActualCell() {
        return actualCell;
    }
}
