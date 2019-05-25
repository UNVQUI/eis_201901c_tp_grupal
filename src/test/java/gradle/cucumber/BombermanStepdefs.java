package gradle.cucumber;

import cucumber.api.java.bs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Bomberman.*;
import cucumber.api.java.en_scouse.An;
import cucumber.api.java.mk_latn.No;

import java.util.List;

import static org.junit.Assert.*;


public class BombermanStepdefs {

    private Bomberman bomberman;
    private Coordinate oldCoordinate;
    private Juego juego;
    private Mapa mapa;
    private List<Celda> celdasAlRededorDeAlgo;
    private ProtoMaxJr protoMaxJr = new ProtoMaxJr();
    @Given("^Un Juego con bomberman en una celda")
    public void crearJuegoMapaConBombermanEnUnaCeldaInicial(){
        juego = new Juego();
        bomberman = this.juego.getBomberman();
        mapa = this.juego.getMapa();
        oldCoordinate = this.cloneCoordinate(this.juego.getPosicionBomberman());
    }

    @When("^Bomberman se mueve hacia la celda vacia (Este|Oeste|Sur|Norte)")
    public void bombermanSeMueveHaciaLaCeldaVaciaNorte(String dirString) {
        Direction actualDirection = this.castDirection(dirString);
        this.juego.moverBomberman(actualDirection);
    }

    @Then("^Bomberman cambia su posicion")
    public void bombermanCambiaSuPosicion() {
        Coordinate positionNow = this.juego.getPosicionBomberman();

        assertNotEquals(oldCoordinate,positionNow);
    }

    @When("^Bomberman intenta moverse al (Este|Oeste|Sur|Norte) habiendo una pared$")
    public void bombermanIntentaMoverseAlNorteHabiendoUnaPared(String dirString) throws Throwable {
        Direction dir = this.castDirection(dirString);
        this.colocarUnItemYMoverloAUnaDireccion(dir, new Pared());
    }

    @Then("^Bomberman se queda en el lugar$")
    public void bombermarEstaEnLaPosicionPasada() throws Throwable {
        assertEquals(this.oldCoordinate, this.juego.getPosicionBomberman());
    }

    @When("^Bomberman intenta moverse al Norte habiendo un enemigo$")
    public  void bombermanIntentaMoverseAlNorteHabiendoEnemigo() throws  Throwable {
        this.colocarUnItemYMoverloAUnaDireccion(new North(), new Enemigo());
    }

    @Then("^Bomberman muere$")
    public void bombermanEstaMuerto() throws  Throwable {
        assertTrue(this.bomberman.siEstaMuerto());
    }

    @When("^Bomberman pone una bomba rodeado de paredes de melamina$")
    public void bombermanPoneUnaBombaYEstaRodeadoDeParadesDeMelamina() throws  Throwable {
        this.bombermanPoneBombaYEstaRodeadoDe(new Pared());
    }

    @And("^Pasa \"([^\"]*)\" ticks$")
    public void pasan3Ticks(String integerValue) throws Throwable {
        this.juego.correnNTicks(Integer.parseInt(integerValue));
    }

    @Then("^La Bomba explota dejando vacio las celdas en un radio de 3 casilleros$")
    public void lasParedesDeLaminaNoExistenMas() throws Throwable {
        assertTrue(this.checkearSiLasCeldasAlRededorDeAlgoEstanVacias());
    }

    @When("^Bomberman pone una bomba rodeado de enemigos$")
    public void bombermanPoneUnaBombaYEstaRodeadoDeEnemigos() throws Throwable {
        this.bombermanPoneBombaYEstaRodeadoDe(new Enemigo());
    }

    @When("^Bomberman pone una bomba rodeada de paredes de acero$")
    public void bomberPoneUnaBombaYEstaRodeadoDeParedesDeAcero() throws  Throwable {
        this.bombermanPoneBombaYEstaRodeadoDe(new ParedAcero());
    }

    @Then("^La Bomba explota sin romper esas paredes de acero$")
    public void noSeRompeNingunaParedDeAcero() throws  Throwable {
        assertFalse(this.checkearSiLasCeldasAlRededorDeAlgoEstanVacias());

    }
    @When("^Bomberman pone una bomba con \"([^\"]*)\" al lado$")
    public void bombermanPoneUnaBombaConUnTipoDeEnemigoAlLado(String enemigoString){
        Enemigo enemigo = this.castEnemigo(enemigoString);
        this.bombermanPoneBombaYEstaRodeadoDe(enemigo);
    }
    @Then("^La Bomba explota donde estaba \"([^\"]*)\" soltando poder \"([^\"]*)\" en la celda")
    public void seMuereEnemigoYDejaCeldaConPoder(String enemigoStr,String poderStr){
        Poder poder = this.castPoder(poderStr);
        Enemigo enemigo= this.castEnemigo(enemigoStr);
        Coordinate coordenadaDondeEstabaEnemigo = new North().giveNextCoordinate(juego.getPosicionBomberman());
        Celda celdaDondeEstabaEnemigo = this.mapa.getCelda(coordenadaDondeEstabaEnemigo);

        assertTrue(celdaDondeEstabaEnemigo.hayPoder());
        assertFalse(celdaDondeEstabaEnemigo.hayEnemigo());
        assertTrue(celdaDondeEstabaEnemigo.hayPoderLanzarBombas());

    }
    @And("^La celda (Este|Oeste|Sur|Norte) donde esta bomberman hay poder \"([^\"]*)\"$")
    public void ponerPoderEnCeldaAContinuacionBomberman(String dirStr,String poderStr){
        Poder poder = this.castPoder(poderStr);
        Direction dir = this.castDirection(dirStr);
        Coordinate coordCeldaContigua = dir.giveNextCoordinate(this.juego.getPosicionBomberman());
        this.mapa.getCelda(coordCeldaContigua).setItem(poder);
    }
    @When("^Bomberman se mueve sobre esa celda (Este|Oeste|Sur|Norte)$")
    public void moverBombermanACeldaContigua(String dirStr){
        Direction dir = this.castDirection(dirStr);
        this.juego.moverBomberman(dir);
    }
    @Then("^Bomberman obtiene el poder \"lanzarBombas\"$")
    public void bombermanObtieneElPoderDeseado(){

        assertTrue(bomberman.tienePoderLanzarBombas());
        assertFalse(bomberman.noTieneNingunPoder());
        assertFalse(bomberman.tienePoderSaltarPared());
        assertFalse(bomberman.tienePoderSaltarYLanzarBombas());
        assertFalse(bomberman.tienePoderSoltarVariasBombas());

    }
    @And("^Bomberman con poder \"([^\"]*)\"$")
    public void ponerPoderEnBomberman(String poderStr){
        Poder poder = this.castPoder(poderStr);
        this.juego.darPoderABomberman(poder);

    }

    @When("^Bomberman lanza bomba mirando al (Este|Oeste|Sur|Norte)$")
    public void bombermanLanzaBombaMirandoA(String dirStr){
        Direction dir = this.castDirection(dirStr);
        this.juego.setDondeMiraBomberman(dir);
        this.juego.bombermanAccionarBomba();
    }

    @Then("^La bomba se pone \"([^\"]*)\" celdas al (Este|Oeste|Sur|Norte) de la posicion de Bomberman$")
    public void checkearQueLaBombaSePoneNCeldasAUnaDireccionDeLaPosicionDeBomberman(String cant,String dirStr){
        int longitudCeldas = Integer.parseInt(cant);
        Direction dir = this.castDirection(dirStr);
        Coordinate coordDondeEstaLaBomba = juego.getPosicionBomberman().obtenerCoordenadas(dir,longitudCeldas);

        assertTrue(this.juego.hayBombaEnCoordenada(coordDondeEstaLaBomba));

    }

    @Then("^La bomba explota$")
    public void laBombaExplota(){
       assertTrue(this.juego.noHayBombasActivas());

    }
    @And("^una pared de metal al sur del bomberman")
    public void ponerParedDeMetalAlSurDelBomberman(){
        Coordinate alSurDelBomberman = new South().giveNextCoordinate(juego.getPosicionBomberman());
        this.mapa.colocarItem(new ParedAcero(), alSurDelBomberman);
    }
    @And("^Proto Max Jr al norte del bomberman")
    public void colocarProtoMaxAlNorteDelBomberman(){
        Coordinate alNorteDelBomberman = new North().giveNextCoordinate(juego.getPosicionBomberman());
        this.mapa.colocarItem(protoMaxJr, alNorteDelBomberman);
    }
    @And("^Proto Max Jr muere")
    public void assertProtomaxMurio(){
        Coordinate alNorteDelBomberman = new North().giveNextCoordinate(juego.getPosicionBomberman());
        assertFalse(mapa.getCelda(alNorteDelBomberman).hayEnemigo());
    }

    private void bombermanPoneBombaYEstaRodeadoDe(Item item) {
        Coordinate posicionActual = this.juego.getPosicionBomberman();
        this.mapa.colocarItemAlRededorDe(item, posicionActual);
        this.celdasAlRededorDeAlgo = this.mapa.getCeldasAlRededorDe(posicionActual);


        assertFalse(this.checkearSiLasCeldasAlRededorDeAlgoEstanVacias());

        this.juego.bombermanAccionarBomba();

    }

    private boolean checkearSiLasCeldasAlRededorDeAlgoEstanVacias() {
        return this.celdasAlRededorDeAlgo.stream().allMatch( c -> c.estaVacio());
    }
    private void colocarUnItemYMoverloAUnaDireccion(Direction direccion, Item item) {
        Coordinate posicionActual = this.juego.getPosicionBomberman();
        this.oldCoordinate = posicionActual;
        this.mapa.colocarItem(item, direccion.giveNextCoordinate(posicionActual));
        this.juego.moverBomberman(direccion);
    }

    private Coordinate cloneCoordinate(Coordinate actual) {
        return new Coordinate(actual.getX(),actual.getY());
    }

    private Coordinate getExpectedCoordinate(String direction,Coordinate actual) {
        switch(direction) {
            case "Norte":
                Coordinate res = this.cloneCoordinate(actual);
                res.incrementY();
                return res;
            case "Sur":
                Coordinate res2 = this.cloneCoordinate(actual);
                res2.decrementY();
                return res2;
            case "Este":
                Coordinate res3 = this.cloneCoordinate(actual);
                res3.incrementX();
                return res3;
            case "Oeste":
                Coordinate res4 = this.cloneCoordinate(actual);
                res4.decrementX();
                return res4;
            default:
                throw new IllegalArgumentException("Solo Norte,Sur,Este,y Oeste son direcciones validas");
        }
    }

    private Direction castDirection(String direccion) {
        switch(direccion) {
            case "Norte":
                return new North();
            case "Sur":
                return new South();
            case "Este":
                return new East();
            case "Oeste":
                return new West();
            default:
                throw new IllegalStateException("Unexpected value: " + direccion);
        }
    }

    private Enemigo castEnemigo(String enemigo) {
        switch(enemigo) {
            case "Enemigo":
                return new Enemigo();
            case "Bagulaa":
                return new Bagulaa();
            case "ProtoMaxJr":
                return new ProtoMaxJr();
            case "ProtoMaxUnits":
                return new ProtoMaxUnits();
            default:
                throw new IllegalStateException("Unexpected value: " + enemigo);
        }
    }

    private Poder castPoder(String poder) {
        switch(poder) {
            case "lanzarBombas":
                return new PoderLanzarBombas();
            case "saltarPared":
                return new PoderSaltarPared();
            case "saltarYLanzar":
                return new PoderSaltarYLanzar();
            case "SoltarVariasBombas":
                return new PoderSoltarVariasBombas();
            default:
                throw new IllegalStateException("Unexpected value: " + poder);
        }
    }


}
