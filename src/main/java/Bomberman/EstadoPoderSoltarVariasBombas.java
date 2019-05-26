package Bomberman;

public class EstadoPoderSoltarVariasBombas extends EstadoPoderLanzarBombas {

    public EstadoPoderSoltarVariasBombas(int alcance,int velocidadExplosion){
        super(alcance,velocidadExplosion);
    }

    @Override
    public void accionDejaBomba(Juego juego){
        juego.bombermanDejaUnaBomba();
    }

    @Override
    public boolean tienePoderSoltarVariasBombas(){return true;}

}
