package gradle.cucumber;

public class ProtoMaxUnit extends Enemy {
    @Override
    public void wasKilledBy(Bomberman bomberman) {
        bomberman.activateWallsJump();
        bomberman.activateMultipleBombs();
    }
}
