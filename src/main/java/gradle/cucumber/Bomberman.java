package gradle.cucumber;

public class Bomberman {
    private boolean estamuerto = false;

    public void morir() {
        this.estamuerto = true;
    }

    public boolean estamuerto() {
        return estamuerto;
    }
}
