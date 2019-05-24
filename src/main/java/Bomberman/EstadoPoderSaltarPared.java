package Bomberman;

public class EstadoPoderSaltarPared extends EstadoPoder {

    @Override
    public void accionBomba(Juego juego){
        juego.bombermanDejaUnaBomba();
    }
}
