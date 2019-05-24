package Bomberman;

public class PoderSoltarVariasBombas extends Poder {

    @Override
    public EstadoPoder crearEstadoPoder(){
        return new EstadoPoderSoltarVariasBombas();
    }

    @Override
    public boolean hayPoderSoltarVariasBombas(){return true;}
}
