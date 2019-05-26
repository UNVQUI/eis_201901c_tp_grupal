package bomberman;

import bomberman.errors.CouldNotJump;
import bomberman.errors.PowerNotFound;

import java.util.ArrayList;
import java.util.List;

public class Bomberman implements CellEntity{

    private Boolean alive = true;
    private List<CellEntity> powers = new ArrayList<>();

    public Bomberman() {}

    public void moveTo(Cell from, Cell to) {
        to.moveToHere(from, this);
    }

    public boolean isIn(Cell otherCell) {
        return otherCell.has(this);
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public void interactWith(CellEntity anotherEntity) {}

    public void kill() {
        this.alive = false;
    }

    public Bomb dropBomb(Cell currentCell){
        Bomb bomb = new Bomb();
        currentCell.put(bomb);
        return bomb;
    }

    public void getPower(CellEntity power) {
        this.powers.add(power);
    }

    public Bomb dropBomb(Cell currentCell, Direction direction, int distance) {
        if (!hasPower(new BagulaaPower())) {
            throw new PowerNotFound();
        }
        Bomb bomb = new Bomb();
        Cell directionCell = currentCell;
        while (distance > 0) {
            directionCell = directionCell.cellAt(direction);
            distance -= 1;
        }
        directionCell.put(bomb);
        return bomb;
    }

    public boolean hasPower(CellEntity newPower) {
        return powers.stream().anyMatch(power -> power.equals(newPower));
    }

    public void jumpTo(Cell currentCell, Direction oneDirection) {
        if (!hasPower(new ProtoMaxJrPower())) {
            throw new PowerNotFound();
        }
        Cell destinyCell = currentCell.cellAt(oneDirection).cellAt(oneDirection);
        if (destinyCell.blocksMovement()) {
            throw new CouldNotJump();
        }
        moveTo(currentCell, destinyCell);
    }
}
