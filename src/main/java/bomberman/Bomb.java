package bomberman;

public class Bomb implements CellEntity{

    private Cell actualCell;
    private TimeCounter counter;
    private int ticksLimit;

    public Bomb(int ticksLimit) {
        this.ticksLimit = ticksLimit;
        this.counter = new TimeCounter(this);
    }

    @Override
    public boolean blocksMovement() {
        return false;
    }

    @Override
    public void interactWith(CellEntity anotherEntity) {

    }

    public void explode(){
        actualCell.getEntities().forEach(x -> x.interactWith(this));
        this.actualCell.getEntities().remove(this);
    }

    public Cell getActualCell() {
        return actualCell;
    }

    public void tick(){
        counter.tick();
    }

    public int getTicksLimit() {
        return ticksLimit;
    }
}
