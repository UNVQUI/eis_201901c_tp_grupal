package gradle.cucumber;


import java.util.ArrayList;

public class Tablero extends Throwable {

    private Pair playerCoord;
    private Bomberman bomberman;
    private Celda[][] celdas;

    public Tablero(int arg1, int arg2) {
        this.celdas = new Celda[arg1][arg2];
        this.crearTodasLasCeldas(arg1, arg2);
    }

    private void crearTodasLasCeldas(int length, int heigth) {
        for(int n = 0; n < length; n++){
            for(int m = 0; m < heigth; m++){
                celdas[n][m] = new Celda(n, m);
            }
        }
    }

    public void ubicarEnCoordenadaInicial(Bomberman bomberman) {
        this.playerCoord = new Pair(1,1);
        this.bomberman = bomberman;
    }

    public void moverALaIzquierdaBomberman() {
        Pair coordenada = Izquierda.mover(this.playerCoord);
        Celda cell = celdas[coordenada.getA()][coordenada.getB()];
        this.playerCoord = cell.getCoordenada();
    }

    public Pair playerCoord() {
        return this.playerCoord;
    }

    public void ubicarEnemigoEnCelda(Pair coordenada) {
        Celda cell = celdas[coordenada.getA()][coordenada.getB()];
        cell.ubicarEnemigo();
    }

    public void moverALaDerechaBomberman() {
        Pair coordenada = Derecha.mover(this.playerCoord);
        Celda cell = celdas[coordenada.getA()][coordenada.getB()];
        this.playerCoord = cell.getCoordenada();
    }
}
