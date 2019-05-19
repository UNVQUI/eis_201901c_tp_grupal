package gradle.cucumber;

public class Enemy {
    private boolean alive = true;
    public void kill() {
        alive = false;
    }

    public boolean isDead() {
        return !alive;
    }
}
