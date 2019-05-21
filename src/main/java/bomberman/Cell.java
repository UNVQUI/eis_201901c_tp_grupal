package bomberman;

public class Cell {
    private CellEntity entity;

    public void put(CellEntity entity) {
        if (this.entity == null) this.entity = entity;
    }

    public boolean has(CellEntity entity) {
        return entity.equals(this.entity);
    }
}
