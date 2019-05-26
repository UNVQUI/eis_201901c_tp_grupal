package Bomberman;

public class PoderSaltarYLanzar extends Poder {

    private int alcance;
    private int velocidadExplosion;

    public PoderSaltarYLanzar(){

        alcance = 4;
        velocidadExplosion = 4;
    }

    @Override
    public EstadoPoder crearEstadoPoder(){
        return new EstadoPoderSaltarYLanzarBombas(alcance,velocidadExplosion);
    }

    @Override
    public boolean hayPoderSaltarYLanzar(){return true;}

}
