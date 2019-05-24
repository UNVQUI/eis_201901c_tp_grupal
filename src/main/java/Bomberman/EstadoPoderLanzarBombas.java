package Bomberman;

public class EstadoPoderLanzarBombas extends EstadoPoder{

    int alcance;
    int velocidadExplosion;

    public EstadoPoderLanzarBombas(int alcance,int velocidadExplosion){
        this.alcance = alcance;
        this.velocidadExplosion = velocidadExplosion;
    }

    @Override
    public void accionBomba(Juego juego){
        juego.bombermanLanzaUnaBomba(alcance,velocidadExplosion);
    }
}
