package bomberman;

public class MelaninWall extends Wall {

    @Override
    public void burnFromExplosion(Cell cell) {
        cell.remove(this);
    }
}
