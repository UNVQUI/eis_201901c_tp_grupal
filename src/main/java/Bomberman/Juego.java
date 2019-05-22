package Bomberman;

public class Juego {

    private Bomberman bomberman;
    private Mapa mapa;
    private Coordinate posicionBomberman;

    public Juego(){
        this.bomberman = new Bomberman();
        this.mapa = new Mapa();
        this.posicionBomberman = new Coordinate(1,1);
    }

    public Mapa getMapa() {
        return mapa;
    }

    public Bomberman getBomberman() {
        return bomberman;
    }

    public void moverBomberman(Direction dir){
        Coordinate nextCoord = dir.giveNextCoordinate(this.getPosicionBomberman());
        this.mapa.getCelda(nextCoord).moverABomberman(this, nextCoord);
    }

    public Celda getCeldaBomberman(){
        return this.mapa.getCelda(this.posicionBomberman);
    }

    public Coordinate getPosicionBomberman(){
        return this.posicionBomberman;
    }

    public void setPosicionBomberman(Coordinate coordenadaAIr){
        this.posicionBomberman = coordenadaAIr;
    }
}
