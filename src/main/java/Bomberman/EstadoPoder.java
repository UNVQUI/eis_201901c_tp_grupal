package Bomberman;

public abstract class EstadoPoder {

    public void accionDejaBomba(Juego juego){}

    public void accionLanzaBomba(Juego juego){}

    public boolean noTieneNingunPoder(){return false;}

    public boolean tienePoderLanzarBombas(){return false;}

    public boolean tienePoderSaltarPared(){return false;}

    public boolean tienePoderSaltarYLanzarBombas(){return false;}

    public boolean tienePoderSoltarVariasBombas(){return false;}


    public void moverme(Item item ,Juego juego, Coordinate hacia)  throws Exception{
        item.bombermanSeMueve(juego,hacia);
    }

}
