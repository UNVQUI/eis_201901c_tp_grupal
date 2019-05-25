package Bomberman;

public class PoderSaltarYLanzar extends PoderLanzarBombas {

    public PoderSaltarYLanzar(){
        super();
    }

    @Override
    public EstadoPoder crearEstadoPoder(){
        return new EstadoPoderSaltarYLanzarBombas(super.alcance,super.velocidadExplosion);
    }

    @Override
    public boolean hayPoderSaltarYLanzar(){return true;}


}
