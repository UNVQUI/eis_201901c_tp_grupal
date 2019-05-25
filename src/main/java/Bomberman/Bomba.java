package Bomberman;

public class Bomba {

    private Coordinate coordenada;
    private Juego juego;
    private int ticks;

    public Bomba(Coordinate posicionBomba, Juego juego,int ticks){
        this.coordenada = posicionBomba;
        this.juego = juego;
        this.ticks = ticks;
    }

    public void decrecerTicks(int t) {
        this.ticks -= t;
        if(this.ticks <= 0) {
            this.juego.estallarBomba(this);
        }
    }

    public Coordinate getCoordenada() {
        return this.coordenada;
    }

    public int getTicks(){return ticks;}

    public boolean yaExploto(){return ticks <= 0;}
}
