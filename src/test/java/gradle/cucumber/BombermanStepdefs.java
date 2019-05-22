package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Bomberman.*;

import static org.junit.Assert.*;


public class BombermanStepdefs {

    private Bomberman bomberman;
    private Coordinate oldCoordinate;
    private Juego juego;
    private Mapa mapa;

    @Given("^Un Juego con bomberman en una celda")
    public void crearJuegoMapaConBombermanEnUnaCeldaInicial(){
        juego = new Juego();
        bomberman = this.juego.getBomberman();
        mapa = this.juego.getMapa();
        oldCoordinate = this.cloneCoordinate(this.juego.getPosicionBomberman());
    }

    @When("^Bomberman se mueve hacia la celda vacia Norte")
    public void bombermanSeMueveHaciaLaCeldaVaciaNorte() {
        Direction actualDirection = new North();
        this.juego.moverBomberman(actualDirection);
    }

    @Then("^Bomberman cambia su posicion")
    public void bombermanCambiaSuPosicion() {
        Coordinate positionNow = this.juego.getPosicionBomberman();

        assertNotEquals(oldCoordinate,positionNow);
    }

    @When("^Bomberman intenta moverse al Norte habiendo una pared$")
    public void bombermanIntentaMoverseAlNorteHabiendoUnaPared() throws Throwable {
        this.colocarUnItemYMoverloAUnaDireccion(new North(), new Pared());
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
    public void bombermanEstaMuerto(){
        assertTrue(this.bomberman.siEstaMuerto());
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

    /*
    @Given("^Bomberman")
    public void newBomberman() throws Throwable {
        bomberman = new Bomberman();
        oldCoordinate = this.cloneCoordinate(mapa.getCoordinate());
    }

    @When("^Lo muevo de celda hacia el (Norte|Sur|Este|Oeste)")
    public void moveToNextCell(String direccion) throws Throwable
    {
        Direction actualDirection = this.castDirection(direccion);
        bomberman.move(actualDirection);
    }



    @Then("^bomberman esta en la proxima celda al (Norte|Sur|Este|Oeste)")
    public void getCoordinate(String direction) throws Throwable {
        Coordinate actual = bomberman.getCoordinate();
        Coordinate expected = this.getExpectedCoordinate(direction,oldCoordinate);

        assertThat(actual).isEqualTo(expected);
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
*/

}
