package bomberman;

public class BagulaaPower implements CellEntity {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public boolean blocksMovement() { return false; }

    @Override
    public void interactWith(CellEntity anotherEntity) {
        if(Bomberman.class.isAssignableFrom(anotherEntity.getClass()))
            ((Bomberman) anotherEntity).getPower(this);
    }

    @Override
    public void burnFromExplosion(Cell cell) {}
}
