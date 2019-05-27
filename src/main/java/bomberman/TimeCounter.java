package bomberman;

public class TimeCounter {

    private Bomb bomb;
    private int tick;

    public TimeCounter(Bomb bomb) {
        this.bomb = bomb;
        this.tick = bomb.getTicksLimit();
    }

    public void tick(Cell cell) {
        tick--;
        if (tick == 0) bomb.explode(cell);
    }
}
