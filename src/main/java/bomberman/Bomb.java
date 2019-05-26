package bomberman;

import bomberman.attributes.CellEntity;
import bomberman.errors.CellNotFound;

public class Bomb implements CellEntity {

    private TimeCounter counter;
    private int ticksLimit;

    public Bomb() {
        this.ticksLimit = 3;
        this.counter = new TimeCounter(this);
    }

    @Override
    public void interactWith(CellEntity anotherEntity) {}

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
            } catch (CellNotFound error) {
            }
        }
    }

    public void tick(Cell cell){
        counter.tick(cell);
    }

    public int getTicksLimit() {
        return ticksLimit;
    }
}
