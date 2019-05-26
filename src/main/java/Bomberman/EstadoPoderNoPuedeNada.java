package Bomberman;

public class EstadoPoderNoPuedeNada extends EstadoPoder {

    @Override
    public void accionDejaBomba(Juego juego){
        juego.bombermanDejaUnaBomba();
    }

    @Override
    public boolean noTieneNingunPoder(){return true;}
}
