package Bomberman;

public class EstadoPoderLanzarVariasBombas extends EstadoPoderLanzarBombas {

    int alcance;
    int velocidadExplosion;

    public EstadoPoderLanzarVariasBombas(int alcance, int velocidadExplosion) {
        super(alcance, velocidadExplosion);
    }

    @Override
    public void accionBomba(Juego juego){
        juego.bombermanLanzaUnaBomba(alcance,velocidadExplosion);
    }

    @Override
    public boolean tienePoderLanzarBombas(){return true;}
}
