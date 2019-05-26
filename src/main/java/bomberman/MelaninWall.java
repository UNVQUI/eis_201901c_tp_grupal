package bomberman;

import bomberman.attributes.Burnable;

public class MelaninWall extends Wall implements Burnable {
    @Override
    public void burnFromExplosion(Cell cell) {
        cell.remove(this);
    }
}
