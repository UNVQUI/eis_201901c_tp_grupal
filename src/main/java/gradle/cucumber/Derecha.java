package gradle.cucumber;

public class Derecha {
    public static Pair mover(Pair playerCoord) {
        return new Pair(playerCoord.getA()+1, playerCoord.getB());
    }
}
