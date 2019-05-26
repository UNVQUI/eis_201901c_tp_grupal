package bomberman;

public class TimeCounter {

    Bomb bomb;
    int tick;

    public TimeCounter(Bomb bomb){
        this.bomb = bomb;
        this.tick = bomb.getTicksLimit();
    }

    public void tick(Cell cell){
        if (tick > 0){
            tick--;
        }
        else{
            bomb.explode(cell);}

    }
}
