package bomberman;

public class TimeCounter {

    Bomb bomb;
    int tick;

    public TimeCounter(Bomb bomb){
        this.bomb = bomb;
    }

    public void tick(Cell cell){
        if (bomb.getTicksLimit()>0){
            tick--;
        }
        bomb.explode(cell);
    }
}
