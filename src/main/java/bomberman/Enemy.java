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
}
