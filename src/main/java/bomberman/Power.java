package bomberman;

import bomberman.attributes.CellEntity;
import bomberman.attributes.Interactible;

public class Power implements CellEntity, Interactible {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    public void interactWith(CellEntity anotherEntity) {
        if(Bomberman.class.isAssignableFrom(anotherEntity.getClass()))
            ((Bomberman) anotherEntity).getPower(this);
    }
}
