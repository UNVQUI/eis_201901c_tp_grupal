package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gradle.cucumber.cuerposEnCeldas.*;

import java.util.ArrayList;
import java.util.List;

//import static org.junit.Assert.assertTrue;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BombermanObtienePoderDeProtoMaxUnitsSteps {
	
	Bomberman bomberman;
	ProtoMaxUnits protoMax;
	Celda celdaCentral;
	Celda celdaAlNorte;
	Celda celdaAlNorte1;
	Celda celdaAlNorte2;
	Celda celdaAlNorte3;
	Acero pared;
    

    @Given("^un bomberman que tiene a un enemigo Proto Max Unit en una celda contigua al \"([^\"]*)\"$")
    public void un_bomberman_que_tiene_a_un_enemigo_Proto_Max_Unit_en_una_celda_contigua_al(String dir) {
    	celdaCentral = new Celda();
    	celdaAlNorte = new Celda();
    	celdaAlNorte1 = new Celda();
    	celdaAlNorte2 = new Celda();
    	celdaAlNorte3 = new Celda();
    	protoMax = new ProtoMaxUnits(celdaAlNorte);
    	celdaCentral.setCeldaAl(dir, celdaAlNorte);
    	bomberman = new Bomberman(celdaCentral);
    }

    @Given("^una pared en la celda al \"([^\"]*)\"$")
    public void una_pared_en_la_celda_al(String dir) {
    	pared = new Acero(celdaAlNorte1);
    	celdaAlNorte.setCeldaAl(dir, celdaAlNorte1);
    	celdaAlNorte1.setCuerpoActual(pared);
    	celdaAlNorte1.setCeldaAl(dir, celdaAlNorte2);
    	celdaAlNorte2.setCeldaAl(dir, celdaAlNorte3);
    }

    @When("^bomberman deja una bomba y esta explota matando a ProtoMaxUnits y su nuevo poder luego de moverse a la celda del \"([^\"]*)\"$")
    public void bomberman_deja_una_bomba_y_esta_explota_matando_a_ProtoMaxUnits_y_su_nuevo_poder_luego_de_moverse_a_la_celda_del(String dir) {
       bomberman.dejarBomba(1);
       celdaCentral.tick();
       bomberman.moverAl(dir);
       bomberman.saltarPared(dir);
       bomberman.soltarVariasBombas(1, dir, 2,2);
    }

    @Then("^bomberman obtiene el poder de protoMax Units$")
    public void bomberman_obtiene_el_poder_de_protoMax_Units() {
    	
    	assertNotEquals(bomberman.getPoder().getClass(), Ninguno.class);
    	assertEquals(celdaCentral.getCuerpoActual(), null);
    	
    	//este assert confirma si, bomberman salto la pared, o bien lanzo 2 bombas en la direccion dada. 
    	//Tomar en cuenta que ProtoMax Units puede soltar cualquiera de los 2 poderes aleatoriamente.
    	assertTrue	((celdaAlNorte.getCuerpoActual() == null && celdaAlNorte2.getCuerpoActual() != null) || 
    				(celdaAlNorte.getCuerpoActual() != null && celdaAlNorte1.getBombaActual() == null 
    				&& celdaAlNorte2.getBombaActual() != null && celdaAlNorte3.getBombaActual() != null));
    }
    
}

/*

 */