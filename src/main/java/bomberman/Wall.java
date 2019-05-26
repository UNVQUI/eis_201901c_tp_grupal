package bomberman;

import bomberman.attributes.SolidEntity;

public class Wall implements CellEntity, SolidEntity {
    @Override
    public void interactWith(CellEntity anotherEntity) {}
}
