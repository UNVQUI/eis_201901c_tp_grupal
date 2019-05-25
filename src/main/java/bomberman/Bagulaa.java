package bomberman;

public class Bagulaa implements CellEntity {
    @Override
    public boolean blocksMovement() { return false; }

    @Override
    public void interactWith(CellEntity anotherEntity) {}

    @Override
    public void burnFromExplosion(Cell cell) {
        cell.remove(this);
        cell.put(new BagulaaPower());
    }
}
