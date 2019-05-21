package bomberman;

public interface CellEntity {
    public boolean blocksMovement();

    public void interactWith(CellEntity anotherEntity);
}
