package gradle.cucumber;

import gradle.cucumber.cuerposEnCeldas.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;

public class BombermanVsProtomaxJr {

    private Bomberman bomberman;
    private ProtoMaxJr protoMaxJr;
    private Celda celdaSegura = new Celda();
    private Acero acero;
    private Celda celdaCentral = new Celda();
    private Celda celdaAlNorte3 = new Celda();
    private Celda celdaAlNorte2 = new Celda();
    private Celda celdaAlNorte1 = new Celda();

    @Given("^Bomberman suelta bomba y alcanza a Proto Max Jr$")
    public void bomberman_suelta_bomba_y_alcanza_a_proto_max_jr() {
        protoMaxJr = new ProtoMaxJr(celdaAlNorte1);
        celdaCentral.setCeldaAl("Norte", celdaAlNorte1);

        bomberman = new Bomberman(celdaCentral);
        bomberman.dejarBomba(1);
        acero = new Acero(celdaAlNorte2);
        celdaAlNorte2.setCuerpoActual(acero);
        celdaAlNorte1.setCeldaAl("Norte", celdaAlNorte2);
        celdaAlNorte2.setCeldaAl("Norte", celdaAlNorte3);
    }


    @When("Proto Max Jr suelta un poder")
    public void proto_max_jr_suelta_un_poder() {
        bomberman.setCeldaActual(celdaSegura);
        celdaCentral.tick();
    }

    @Then("^Bomberman puede saltar todo tipo de pared$")
    public void bomberman_puede_saltar_todo_tipo_de_pared() {
       bomberman.setCeldaActual(celdaCentral);
       bomberman.moverAl("Norte");
       assertTrue(bomberman.getPoder().getClass().equals(SaltarParedes.class) );
    }
}
