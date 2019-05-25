package Bomberman;

public class PoderLanzarBombas extends Poder {

    int alcance;
    int velocidadExplosion;

    public PoderLanzarBombas(){
        this.alcance = 4;
        this.velocidadExplosion = 4;
    }

    @Override
    public EstadoPoder crearEstadoPoder(){
        return new EstadoPoderLanzarBombas(this.alcance,this.velocidadExplosion);
    }

    @Override
    public boolean hayPoderLanzarBombas(){return true;}
}
