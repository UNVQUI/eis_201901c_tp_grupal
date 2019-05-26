package bomberman;

import bomberman.attributes.CellEntity;

public class Power implements CellEntity {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public void interactWith(CellEntity anotherEntity) {
        if(Bomberman.class.isAssignableFrom(anotherEntity.getClass()))
            ((Bomberman) anotherEntity).getPower(this);
    }
}
