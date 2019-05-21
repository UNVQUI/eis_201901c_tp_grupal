package bomberman;

public class Wall implements CellEntity{
    @Override
    public boolean blocksMovement() {
        return true;
    }

    @Override
    public void interactWith(CellEntity anotherEntity) {}
}
