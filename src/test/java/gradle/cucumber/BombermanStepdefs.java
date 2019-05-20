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

    @Given("^Un Juego que contiene mapa con Bomberman en su celda inicial")
    public void crearJuegoMapaConBombermanEnUnaCeldaInicial(){
        bomberman = new Bomberman();
        mapa = new Mapa();
        juego = new Juego(bomberman,mapa);
        oldCoordinate = this.cloneCoordinate(mapa.getPosicionBomberman());
    }

    @When("^Bomberman se mueve hacia la celda vacia Norte")
    public void bombermanSeMueveHaciaLaCeldaVaciaNorte() {
        Direction actualDirection = new North();
        mapa.moverBomberman(actualDirection);
    }

    @Then("^Bomberman cambia su posicion")
    public void bombermanCambiaSuPosicion() {
        Coordinate positionNow = mapa.getPosicionBomberman();

        assertNotEquals(oldCoordinate,positionNow);
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
