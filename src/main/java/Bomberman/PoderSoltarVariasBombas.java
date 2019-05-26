package Bomberman;

public class PoderSoltarVariasBombas extends Poder {

    private int alcance;
    private int velocidadExplosion;

    public PoderSoltarVariasBombas(){
        this.alcance = 4;
        this.velocidadExplosion = 4;
    }

    @Override
    public EstadoPoder crearEstadoPoder(){
        return new EstadoPoderSoltarVariasBombas(alcance,velocidadExplosion);
    }

    @Override
    public boolean hayPoderSoltarVariasBombas(){return true;}
}
