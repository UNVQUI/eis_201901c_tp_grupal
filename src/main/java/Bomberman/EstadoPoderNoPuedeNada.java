package Bomberman;

public class EstadoPoderNoPuedeNada extends EstadoPoder {

    @Override
    public void accionBomba(Juego juego){
        juego.bombermanDejaUnaBomba();
    }
}
