package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombermanStepdefs {

    Tablero tablero;
    Bomberman bomberman;

    @Given("^un tablero de (\\d+) x (\\d+)$")
    public void un_tablero_de_x(int arg1, int arg2) {
        tablero = new Tablero(arg1, arg2);
    }

    @Given("^bomberman en una coordenado valida$")
    public void bomberman_en_una_coordenado_valida() {
        bomberman = new Bomberman();
        tablero.ubicarEnCoordenadaInicial(bomberman);
    }

    @Given("^un enemigo en una coordenada valida")
    public void un_enemigo_en_una_coordenada_valida(){
        tablero.ubicarEnemigoEnCelda(new Pair(2,1));
    }

    @When("^se mueve a la izquierda$")
    public void se_mueve_a_la_izquierda() {
        tablero.moverALaIzquierdaBomberman();
    }

    @When("^bomberman se mueve a la derecha")
    public void bomberman_se_mueve_a_la_derecha(){
        tablero.moverALaDerechaBomberman();
    }

    @Then("^bomberman cambio su coordenada$")
    public void bomberman_cambio_su_coordenada() {
        assertEquals(0, tablero.playerCoord().getA());
        assertEquals(1, tablero.playerCoord().getB());
    }

    @Then("^bomberman muere")
    public void bomberman_muere(){
        assertTrue(bomberman.estamuerto());
    }
}
