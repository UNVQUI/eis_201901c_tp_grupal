package bomberman;

public class Enemy implements CellEntity {

    @Override
    public boolean blocksMovement() {
        return false;
    }

    @Override
    public void interactWith(CellEntity anotherEntity) {
        if(Bomberman.class.isAssignableFrom(anotherEntity.getClass())) {
            ((Bomberman)anotherEntity).kill();
        }
    }

    @Override
    public void burnFromExplosion(Cell cell) {
        cell.remove(this);
    }
}
