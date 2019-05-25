package bomberman;

import bomberman.errors.CouldNotJump;
import bomberman.errors.PowerNotFound;

import java.util.ArrayList;
import java.util.List;

public class Bomberman implements CellEntity{

    private Cell actualCell = new Cell();
    private Boolean alive = true;
    private List<CellEntity> powers = new ArrayList<>();

    public Bomberman() {
        actualCell.put(this);
    }

    public Bomberman(Cell actualCell) {
        this.actualCell = actualCell;
        actualCell.put(this);
    }

    public void moveTo(Cell contingentCell) {
        contingentCell.moveToHere(actualCell, this);
    }

    public boolean isIn(Cell otherCell) {
        return otherCell.has(this);
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public boolean blocksMovement() {
        return false;
    }

    @Override
    public void interactWith(CellEntity anotherEntity) {}

    @Override
    public void burnFromExplosion(Cell cell) {}

    public void kill() {
        this.alive = false;
    }

    public Bomb dropBomb(){
        Bomb bomb = new Bomb();
        actualCell.put(bomb);
        return bomb;
    }

    public Cell getActualCell() {
        return actualCell;
    }

    public void getPower(CellEntity power) {
        this.powers.add(power);
    }

    public Bomb dropBomb(Direction direction, int distance) {
        if (!hasPower(new BagulaaPower())) {
            throw new PowerNotFound();
        }
        Bomb bomb = new Bomb();
        Cell directionCell = actualCell;
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

    public void jumpTo(Direction oneDirection) {
        if (!hasPower(new ProtoMaxJrPower())) {
            throw new PowerNotFound();
        }
        Cell destinyCell = this.actualCell.cellAt(oneDirection).cellAt(oneDirection);
        if (destinyCell.blocksMovement()) {
            throw new CouldNotJump();
        }
        moveTo(destinyCell);
    }
}
