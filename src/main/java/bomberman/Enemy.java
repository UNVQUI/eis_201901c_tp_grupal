package bomberman;

import bomberman.attributes.Burnable;
import bomberman.attributes.CellEntity;
import bomberman.attributes.Interactible;

public class Enemy implements CellEntity, Burnable, Interactible {

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
