package gradle.cucumber;

public class Celda {
    private Pair coordenada;
    private boolean tieneEnemigo;

    public Celda(int x, int y){
        this.coordenada = new Pair(x, y);
    }

    public Pair getCoordenada() {
        return this.coordenada;
    }

    public void ubicarEnemigo() {
        this.tieneEnemigo = true;
    }
}
