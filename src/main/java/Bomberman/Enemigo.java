package Bomberman;

public class Enemigo implements Item {

    @Override
    public void bombermanSeMueve(Juego juego, Coordinate coordenadaAIr) {
        juego.getBomberman().morir();
    }

    @Override
    public boolean estaVacio() {
        return false;
    }
}
