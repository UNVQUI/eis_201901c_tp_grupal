package gradle.cucumber;

public class ProtoMaxJr extends Enemy {
    @Override
    public void wasKilledBy(Bomberman bomberman) {
        bomberman.activateWallsJump();
    }
}
