package Bomberman;

public class Enemigo extends Item {

    @Override
    public void bombermanSeMueve(Juego juego, Coordinate coordenadaAIr) {
        juego.getBomberman().morir();
    }

    @Override
    public void explote(Celda celda) {
        celda.setItem(new Vacio());
    }

    @Override
    public boolean hayEnemigo(){
        return true;
    }


}
