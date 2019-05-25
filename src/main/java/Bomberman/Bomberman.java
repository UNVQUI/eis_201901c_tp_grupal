package Bomberman;

public class Bomberman {

    //REFACTOR SI SE LLEGA A UN ESTADOVIVO()
    private Boolean estaVivo;
    private EstadoPoder miPoder = new EstadoPoderNoPuedeNada();

    public Bomberman () {
        this.estaVivo = true;
    }

    public boolean siEstaMuerto() {
        return !this.estaVivo;
    }

    public void morir() {
        this.estaVivo = false;
    }

    public void accionBomba(Juego juego) {
        if(this.estaVivo){
            this.miPoder.accionBomba(juego);
        }
    }

    public void obtenerPoder(EstadoPoder estadoPoder){
        if(this.estaVivo) {
            this.miPoder = estadoPoder;
        }
    }

    public boolean noTieneNingunPoder(){return this.miPoder.noTieneNingunPoder();}

    public boolean tienePoderLanzarBombas(){return miPoder.tienePoderLanzarBombas();}

    public boolean tienePoderSaltarPared(){return miPoder.tienePoderSaltarPared();}

    public boolean tienePoderSaltarYLanzarBombas(){return miPoder.tienePoderSaltarYLanzarBombas();}

    public boolean tienePoderSoltarVariasBombas(){return miPoder.tienePoderSoltarVariasBombas();}


    public void moverse(Item item, Juego juego, Coordinate hacia) {
        miPoder.moverme(item,juego,hacia);
    }

}
