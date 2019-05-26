package bomberman;

public class ProtoMaxUnits extends Enemy {
    @Override
    public void burnFromExplosion(Cell cell) {
        super.burnFromExplosion(cell);
        cell.put(new ProtoMaxJrPower());
    }
}
