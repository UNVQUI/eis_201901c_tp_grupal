package bomberman;

public class Enemy implements CellEntity {

    private Boolean alive = true ;

    @Override
    public boolean blocksMovement() {
        return false;
    }

    @Override
    public void interactWith(CellEntity anotherEntity) {
        if(Bomberman.class.isAssignableFrom(anotherEntity.getClass())) {
            ((Bomberman)anotherEntity).kill();
        }
        if(Bomb.class.isAssignableFrom((anotherEntity.getClass()))){
            this.kill();
        }
    }

    @Override
    public void burnFromExplosion(Cell cell) {
        cell.remove(this);
    }

    public boolean isAlive (){return alive;}

    public void kill() {
        this.alive = false;
    }
}
