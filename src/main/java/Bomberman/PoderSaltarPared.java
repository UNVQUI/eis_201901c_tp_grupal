package Bomberman;

public class PoderSaltarPared extends Poder{

    @Override
    public EstadoPoder crearEstadoPoder(){
        return new EstadoPoderSaltarPared();
    }

    @Override
    public boolean hayPoderSaltarPared(){return true;}
}
