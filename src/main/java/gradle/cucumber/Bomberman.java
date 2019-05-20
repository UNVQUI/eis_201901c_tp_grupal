package gradle.cucumber;

import java.util.List;

public class Bomberman {

    public Cell location;
    public boolean canJumpWalls;
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

    public void dropBomb(BombermanGrid grid) {
        List<Enemy> enemies = grid.bombDropped(this.location);
        enemies.forEach(enemy -> enemy.wasKilledBy(this));
    }

    public void activateWallsJump() {
        canJumpWalls = true;
    }
}
