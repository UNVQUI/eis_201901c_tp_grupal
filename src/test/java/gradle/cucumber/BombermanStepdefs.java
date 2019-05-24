package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class BombermanStepdefs {

    @Given("^un tablero de (\\d+) x (\\d+)$")
    public void un_tablero_de_x(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^bomberman en una coordenado valida$")
    public void bomberman_en_una_coordenado_valida() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^se mueve a la izquierda$")
    public void se_mueve_a_la_izquierda() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^bomberman cambio su coordenada$")
    public void bomberman_cambio_su_coordenada() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
