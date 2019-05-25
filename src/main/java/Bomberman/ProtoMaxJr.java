package Bomberman;

public class ProtoMaxJr extends Enemigo {
    private Poder poder;

    public ProtoMaxJr() {
        this.poder = new PoderSaltarPared();
    }

    @Override
    public void explote(Celda celda, Juego juego) {
        juego.darPoderABomberman(this.poder);
    }
}
