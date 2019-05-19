package gradle.cucumber;

public class Bomberman {
    public Cell location;
    private Boolean isDead = false;
    public void moveTo(Cell cell) {
        cell.locateBomberman(this);
    }

    public boolean isAtCell(Cell cell) {
        return cell == location;
    }

    public boolean isDead() {
        return isDead;
    }

    public void die() {
        isDead = true;
    }
}
