package Bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Juego {

    private Bomberman bomberman;
    private Mapa mapa;
    private Coordinate posicionBomberman;
    private Direction dondeMiraBomberman;
    private List<Bomba> bombas;

    public Juego(){
        this.bombas = new ArrayList<Bomba>();
        this.bomberman = new Bomberman();
        this.mapa = new Mapa();
        this.posicionBomberman = new Coordinate(1,1);
        this.dondeMiraBomberman = new North();
    }

    public Mapa getMapa() {
        return mapa;
    }

    public Bomberman getBomberman() {
        return bomberman;
    }

    public void moverBomberman(Direction dir){
        //REFACTOR SI SE LLEGA
        if(! this.bomberman.siEstaMuerto()){
            Coordinate nextCoord = dir.giveNextCoordinate(this.getPosicionBomberman());
            this.mapa.getCelda(nextCoord).moverABomberman(this, nextCoord);
        }
    }

    public Celda getCeldaBomberman(){
        return this.mapa.getCelda(this.posicionBomberman);
    }

    public Coordinate getPosicionBomberman(){
        return this.posicionBomberman;
    }

    public void setPosicionBomberman(Coordinate coordenadaAIr){
        this.posicionBomberman = coordenadaAIr;
    }

    public void bombermanAccionarBomba() {
        this.bomberman.accionBomba(this);
    }

    public void bombermanDejaUnaBomba() {
        this.bombas.add(new Bomba(this.getPosicionBomberman(), this,3));
    }

    public void correnNTicks(int ticks) {
        this.bombas.forEach(bomba -> bomba.decrecerTicks(ticks));
        this.bombas = this.bombas.stream().filter(b -> !b.yaExploto()).collect(Collectors.toList());
    }

    public void estallarBomba(Bomba bomba) {
        List<Celda> celdasAExplotar = this.mapa.getCeldasAlRededorDe(bomba.getCoordenada());
        celdasAExplotar.forEach(celda -> celda.explotar(this));
    }

    public void darPoderABomberman(Poder poder){

        bomberman.obtenerPoder(poder.crearEstadoPoder());
    }

    public void bombermanLanzaUnaBomba(int alcance, int velocidadExplosion) {

        List<Celda> segmentoDeCeldas = this.mapa.getSegmentoDeCeldas(this.dondeMiraBomberman,this.posicionBomberman,alcance);

        Coordinate dondeCaeBomba = mapa.obtenerCeldaMasLejanaDelSegmento(this.posicionBomberman,segmentoDeCeldas).getCoordenada();

        this.bombas.add(new Bomba(dondeCaeBomba,this,velocidadExplosion));

    }


    public void setDondeMiraBomberman(Direction dir){
        //TODO REFACTORIZAR
        if(!bomberman.siEstaMuerto()){
            this.dondeMiraBomberman = dir;
        }

    }

    public boolean hayBombaEnCoordenada(Coordinate c){
        return this.bombas.stream().anyMatch(b -> b.getCoordenada().equals(c));
    }

    public boolean noHayBombasActivas(){
        return this.bombas.isEmpty();
    }
}
