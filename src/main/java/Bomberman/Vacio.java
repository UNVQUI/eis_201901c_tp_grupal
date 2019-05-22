package Bomberman;

public class Vacio implements Item {

    @Override
    public void bombermanSeMueve(Juego juego, Coordinate coordenadaAIr) {
        juego.setPosicionBomberman(coordenadaAIr);
    }
}
