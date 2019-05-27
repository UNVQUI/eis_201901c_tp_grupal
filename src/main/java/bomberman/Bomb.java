package bomberman;

import bomberman.attributes.CellEntity;
import bomberman.attributes.Tickeable;
import bomberman.errors.CellNotFound;

public class Bomb implements CellEntity, Tickeable {

    private TimeCounter counter;
    private int ticksLimit;

    public Bomb() {
        this.ticksLimit = 3;
        this.counter = new TimeCounter(this);
    }

    public int getTicksLimit() {
        return ticksLimit;
    }

    public void tick(Cell cell){
        counter.tick(cell);
    }

    public void explode(Cell cell){
        cell.burnFromExplosion();
        for (Direction direction : Direction.values()) {
            try {
                int wavelength = 3;
                Cell directionCell = cell;
                while (wavelength > 0) {
                    directionCell = directionCell.cellAt(direction);
                    wavelength -= 1;
                    directionCell.burnFromExplosion();
                }
            } catch (CellNotFound error) {}
        }
        cell.remove(this);
    }
}
