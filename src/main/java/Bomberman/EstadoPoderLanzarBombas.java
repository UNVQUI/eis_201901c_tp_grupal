package Bomberman;

public class EstadoPoderLanzarBombas extends EstadoPoder{

    private int alcance;
    private int velocidadExplosion;

    public EstadoPoderLanzarBombas(int alcance,int velocidadExplosion){
        this.alcance = alcance;
        this.velocidadExplosion = velocidadExplosion;
    }

    @Override
    public void accionLanzaBomba(Juego juego){
        juego.bombermanLanzaUnaBomba(alcance,velocidadExplosion);
    }

    @Override
    public void accionDejaBomba(Juego juego) {
        this.accionLanzaBomba(juego);
    }

    @Override
    public boolean tienePoderLanzarBombas(){return true;}
}
