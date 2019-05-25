package Bomberman;

public abstract class EstadoPoder {

    public abstract void accionBomba(Juego juego);

    public boolean noTieneNingunPoder(){return false;}

    public boolean tienePoderLanzarBombas(){return false;}

    public boolean tienePoderSaltarPared(){return false;}

    public boolean tienePoderSaltarYLanzarBombas(){return this.tienePoderLanzarBombas() && this.tienePoderSaltarPared();}

    public boolean tienePoderSoltarVariasBombas(){return false;}
}
