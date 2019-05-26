package Bomberman;

public class EstadoPoderSaltarPared extends EstadoPoder {

    @Override
    public void accionDejaBomba(Juego juego){
        juego.bombermanDejaUnaBomba();
    }

    @Override
    public boolean tienePoderSaltarPared(){return true;}

    @Override
    public void moverme( Item item ,Juego juego, Coordinate hacia) {
        item.saltarPared(juego,hacia);
    }
}
