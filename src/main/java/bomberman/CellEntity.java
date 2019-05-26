package bomberman;

public interface CellEntity {
    public void interactWith(CellEntity anotherEntity);

    public void burnFromExplosion(Cell cell);
}
