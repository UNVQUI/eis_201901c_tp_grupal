package bomberman;

import bomberman.errors.CellNotFound;

import java.util.Arrays;

public class Bomb implements CellEntity{

    private TimeCounter counter;
    private int ticksLimit;

    public Bomb() {
        this.ticksLimit = 3;
        this.counter = new TimeCounter(this);
    }

    @Override
    public boolean blocksMovement() {
        return false;
    }

    @Override
    public void interactWith(CellEntity anotherEntity) {}

    @Override
    public void burnFromExplosion(Cell cell) {}

    public void explode(Cell cell){
        cell.burnFromExplosion();
        Arrays
            .stream(Direction.values())
            .forEach(direction -> {
                try {
                    Integer wavelength = 3;
                    Cell directionCell = cell;
                    while (wavelength > 0) {
                        directionCell = directionCell.cellAt(direction);
                        wavelength -= 1;
                        directionCell.burnFromExplosion();
                    }
                } catch (CellNotFound error){}
            });
    }

    public void tick(Cell cell){
        counter.tick(cell);
    }

    public int getTicksLimit() {
        return ticksLimit;
    }
}
