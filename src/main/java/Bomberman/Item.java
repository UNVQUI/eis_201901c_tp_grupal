package Bomberman;

public abstract class Item {
    public abstract void bombermanSeMueve(Juego juego, Coordinate coordenadaAIr)  throws Exception;

    public void explote(Celda celda, Juego juego){celda.setItem(new Vacio()); };

    public boolean estaVacio() {
        return false;
    }

    public boolean hayPoder(){ return false;}

    public boolean hayPoderLanzarBombas(){return false;}

    public boolean hayPoderSaltarPared(){return false;}

    public boolean hayPoderSaltarYLanzar(){return false;}

    public boolean hayPoderSoltarVariasBombas(){return false;}

    public boolean hayEnemigo(){return false;}

    public boolean hayPoderLanzarVariasBombas(){return false;};

    public void saltarPared(Juego juego,Coordinate coordenadaAIr){
        juego.setPosicionBomberman(coordenadaAIr);
    }
}
