package Bomberman;

public class Bagulaa extends Enemigo {

    private Poder poder;

    public Bagulaa(){
        this.poder = new PoderLanzarBombas();
    }

    @Override
    public void explote(Celda celda) {
        celda.setItem(this.poder);
    }
}
