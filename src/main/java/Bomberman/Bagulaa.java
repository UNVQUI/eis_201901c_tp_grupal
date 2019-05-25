package Bomberman;

public class Bagulaa extends Enemigo {

    private Poder poder;

    public Bagulaa(){
        this.poder = new PoderLanzarBombas();
    }

    @Override
    public void explote(Celda celda, Juego juego) {
        celda.setItem(this.poder);
    }
}
