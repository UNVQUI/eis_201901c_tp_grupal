package bomberman;

import bomberman.attributes.Burnable;

public class Enemy implements CellEntity, Burnable {
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
