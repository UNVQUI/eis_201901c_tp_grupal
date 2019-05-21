package bomberman;

public class Bomberman implements CellEntity{
    public void moveTo(Cell contingentCell) {
        contingentCell.put(this);
    }

    public boolean isIn(Cell otherCell) {
        return otherCell.has(this);
    }

    public boolean isAlive() {
        return true;
    }
}
