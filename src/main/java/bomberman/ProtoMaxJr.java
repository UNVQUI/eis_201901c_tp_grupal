package bomberman;

public class ProtoMaxJr extends Enemy {

    @Override
    public void burnFromExplosion(Cell cell) {
        super.burnFromExplosion(cell);
        cell.put(new ProtoMaxJrPower());
    }
}
