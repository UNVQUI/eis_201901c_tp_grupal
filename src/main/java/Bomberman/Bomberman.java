package Bomberman;

public class Bomberman {

    //REFACTOR SI SE LLEGA A UN ESTADOVIVO()
    private Boolean estaVivo;
    private EstadoPoder miPoder ;

    public Bomberman () {
        this.miPoder = new EstadoPoderNoPuedeNada();
        this.estaVivo = true;
    }

    public boolean siEstaMuerto() {
        return !this.estaVivo;
    }

    public void morir() {
        this.estaVivo = false;
    }

    public void accionDejaBomba(Juego juego) {
        if(this.estaVivo){
            this.miPoder.accionDejaBomba(juego);
        }
    }

    public void accionLanzaBomba(Juego juego){
        if(this.estaVivo)
            this.miPoder.accionLanzaBomba(juego);
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


    public void moverse(Item item, Juego juego, Coordinate hacia) throws Exception{
        if(estaVivo){
            miPoder.moverme(item,juego,hacia);
        }
    }

    public Direction cambiarDondeMira(Direction dir){
        //TODO REFACTOR DE NULL A EXCEPTION ESTAMUERTOBOMBERMAN()
        if(estaVivo){
            return dir;
        }

        return null;
    }

}
