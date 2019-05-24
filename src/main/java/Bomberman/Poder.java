package Bomberman;

public abstract class Poder extends Item {

    @Override
    public void bombermanSeMueve(Juego juego, Coordinate coordenadaAIr){
        juego.setPosicionBomberman(coordenadaAIr);
        juego.darPoderABomberman(this);
        juego.getCeldaBomberman().setItem(new Vacio());
    }

    public abstract EstadoPoder crearEstadoPoder();

    @Override
    public boolean hayPoder(){ return true;}

    @Override
    public boolean hayPoderLanzarBombas(){return false;}

    @Override
    public boolean hayPoderSaltarPared(){return false;}

    @Override
    public boolean hayPoderSaltarYLanzar(){return false;}

    @Override
    public boolean hayPoderSoltarVariasBombas(){return false;}
}

