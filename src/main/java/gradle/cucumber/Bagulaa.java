package gradle.cucumber;

public class Bagulaa extends Enemy {
    @Override
    public void wasKilledBy(Bomberman bomberman) {
        bomberman.activateSuperBomb();
    }
}