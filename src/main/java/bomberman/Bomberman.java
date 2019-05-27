package bomberman;

import bomberman.attributes.CellEntity;
import bomberman.errors.CouldNotJump;
import bomberman.errors.PowerNotFound;

import java.util.ArrayList;
import java.util.List;

public class Bomberman implements CellEntity {

    private Boolean alive = true;
    private List<CellEntity> powers = new ArrayList<>();

    public Bomberman() {}

    public void moveTo(Cell from, Cell to) {
        to.moveToHere(from, this);
    }

    public boolean isIn(Cell otherCell) { return otherCell.has(this); }

    public boolean isAlive() {
        return alive;
    }

    public void kill() {
        this.alive = false;
    }

    public Bomb dropBomb(GameMap gameMap) {
        ensureEnoughPowerToDropBomb(gameMap);
        Bomb bomb = new Bomb();
        gameMap.getEntityCell(this).put(bomb);
        return bomb;
    }

    private void ensureEnoughPowerToDropBomb(GameMap gameMap) {
        if(!hasPower(new ProtoMaxUnitsPower()) && !gameMap.assignableEntities(Bomb.class).isEmpty())
            throw new PowerNotFound();
    }

    public Bomb dropBomb(GameMap gameMap, Direction direction, int distance) {
        ensureEnoughPowerToDropBomb(gameMap);
        if (!hasPower(new BagulaaPower()) && !hasPower(new ProtoMaxUnitsPower()))
            throw new PowerNotFound();
        Bomb bomb = new Bomb();
        Cell directionCell = gameMap.getEntityCell(this);
        while (distance > 0) {
            directionCell = directionCell.cellAt(direction);
            distance -= 1;
        }
        directionCell.put(bomb);
        return bomb;
    }

    public void getPower(CellEntity power) {
        this.powers.add(power);
    }

    public boolean hasPower(CellEntity newPower) {
        return powers.stream().anyMatch(power -> power.equals(newPower));
    }

    public void jumpTo(Cell currentCell, Direction oneDirection) {
        if (!hasPower(new ProtoMaxJrPower()) && !hasPower(new ProtoMaxUnitsPower()))
            throw new PowerNotFound();
        Cell destinyCell = currentCell.cellAt(oneDirection).cellAt(oneDirection);
        if (destinyCell.blocksMovement()) throw new CouldNotJump();
        moveTo(currentCell, destinyCell);
    }
}

    