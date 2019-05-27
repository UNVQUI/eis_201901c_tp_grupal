package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gradle.cucumber.cuerposEnCeldas.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BombermanSeMueveEntreCeldasSteps {
    private Celda celdaAnterior = new Celda();
    private Celda nuevaCelda = new Celda();
    private Celda celdaPared = new Celda();
    private Celda celdaConEnemigo = new Celda();
    private Pared paredMelamina = new Melamina(celdaPared);
    private Bomberman bomberman = new Bomberman(celdaAnterior);
    private List<Poder> poderes = new ArrayList();
    private Enemigo enemigo = new ProtoMaxUnits(celdaConEnemigo);


    @Given("^un Bomberman con una celda vacia al \"([^\"]*)\"$")
    public void un_Bomberman_con_una_celda_vacia_al(String dir) {
        celdaAnterior.setCeldaAl(dir,nuevaCelda);
    }

    @When("^Bomberman se mueve al \"([^\"]*)\"$")
    public void bomberman_se_mueve_al(String dir) {
        bomberman.moverAl(dir);
    }

    @Then("^Bomberman cambia su posicion$")
    public void bomberman_cambia_su_posicion() {
		
        assertTrue(celdaAnterior.getCuerpoActual() == null);
        assertTrue(nuevaCelda.getCuerpoActual() != null);
    }


    @Given("^un bomberman con una celda ocupada por una pared ubicada al \"([^\"]*)\"$")
    public void un_bomberman_con_una_celda_ocupada_por_una_pared_ubicada_al(String dir) {
        celdaAnterior.setCeldaAl(dir,celdaPared);
    }

    @Then("^Bomberman no cambia de celda$")
    public void bomberman_no_cambia_de_celda() {
        assertTrue(celdaAnterior.getCuerpoActual() != null);
        assertTrue(nuevaCelda.getCuerpoActual() == null);
    }

    @Given("^un bomberman con una celda ocupada por un enemigo al \"([^\"]*)\"$")
    public void un_bomberman_con_una_celda_ocupada_por_un_enemigo_al(String dir) {
        celdaAnterior.setCeldaAl(dir,celdaConEnemigo);
    }
    @Then("^Bomberman pasa a estar muerto$")
    public void bomberman_pasa_a_estar_muerto() {
       assertFalse(bomberman.getEstavivo());
    }

}
