package bomberman;

public class Bagulaa extends Enemy {
    @Override
    public void burnFromExplosion(Cell cell) {
        super.burnFromExplosion(cell);
        cell.put(new BagulaaPower());
    }
}
