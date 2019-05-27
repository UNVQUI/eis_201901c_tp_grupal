package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gradle.cucumber.cuerposEnCeldas.Acero;
import gradle.cucumber.cuerposEnCeldas.Bomberman;
import gradle.cucumber.cuerposEnCeldas.Enemigo;
import gradle.cucumber.cuerposEnCeldas.Melamina;
import gradle.cucumber.cuerposEnCeldas.ProtoMaxUnits;

import static junit.framework.TestCase.assertTrue;

public class BombermanDejaBombas {
    private Celda celdaAnterior = new Celda();
    private Celda celdaNueva = new Celda();
    private Melamina melamina;
    private Bomberman bomberman;
    private Celda celdaCentral = new Celda();
    private Celda celdaAlEste3 = new Celda();
    private Celda celdaAlOeste3 = new Celda();
    private Celda celdaAlSur3 = new Celda();
    private Celda celdaAlNorte3 = new Celda();

    @Given("^una Celda Con un Bomberman y una celda con una pared de melamina al \"([^\"]*)\"$")
    public void un_Bomberman_con_una_pared_de_melamina_al(String dir) {
		 bomberman = new Bomberman(celdaAnterior);
    	 melamina = new Melamina(celdaNueva);
    	 celdaAnterior.setCeldaAl(dir, celdaNueva);
    }

    @When("^bomberman deja una bomba de \"([^\"]*)\"$")
    public void bomberman_deja_una_bomba_de(String tiempo) {
    	bomberman.dejarBomba(Integer.parseInt(tiempo));
    }

    @Then("^la bomba explota y rompe la pared$")
    public void bomba_explota_y_rompe_pared() {
    	
    	assertTrue(celdaNueva.getCuerpoActual().getClass() == Melamina.class);
    	//Por ahora esta es mi unica forma de hacer explotar una bomba
    	for (int i =2; i >= 0; i--) {
    		celdaAnterior.tick();
    	}
    	
    	assertTrue (celdaNueva.getCuerpoActual() == null);
    	assertTrue (celdaAnterior.getBombaActual() == null);
    }
    
    
    @Given("^una Celda con un Bomberman rodeado de paredes de melamina en un radio de 3 celdas$")
    public void una_Celda_con_un_Bomberman_rodeado_de_paredes_de_melamina_en_un_radio_de_3_celdas() {
    	bomberman = new Bomberman(celdaCentral);
    	
    	celdaCentral.setCeldaAlEste(new Celda());
    	celdaCentral.getCeldaAlEste().setCeldaAlEste(new Celda());
    	celdaCentral.getCeldaAlEste().getCeldaAlEste().setCeldaAlEste(celdaAlEste3);
    	new Melamina(celdaAlEste3);
    	
    	celdaCentral.setCeldaAlOeste(new Celda());
    	celdaCentral.getCeldaAlOeste().setCeldaAlOeste(new Celda());
    	celdaCentral.getCeldaAlOeste().getCeldaAlOeste().setCeldaAlOeste(celdaAlOeste3);
    	new Melamina(celdaAlOeste3);
    	
    	celdaCentral.setCeldaAlSur(new Celda());
    	celdaCentral.getCeldaAlSur().setCeldaAlSur(new Celda());
    	celdaCentral.getCeldaAlSur().getCeldaAlSur().setCeldaAlSur(celdaAlSur3);
    	new Melamina(celdaAlSur3);
    	
    	celdaCentral.setCeldaAlNorte(new Celda());
    	celdaCentral.getCeldaAlNorte().setCeldaAlNorte(new Celda());
    	celdaCentral.getCeldaAlNorte().getCeldaAlNorte().setCeldaAlNorte(celdaAlNorte3);
    	new Melamina(celdaAlNorte3);
    }
    
    @When("^bomberman deja otra bomba de \"([^\"]*)\"$")
    public void bomberman_deja_otra_bomba_de(String tiempo) {
    	bomberman.dejarBomba(Integer.parseInt(tiempo));
    }

    @Then("^la bomba explota y rompe todas las paredes$")
    public void la_bomba_explota_y_rompe_todas_las_paredes() {
    	
    	for (int i =2; i >= 0; i--) {
    		celdaCentral.tick();
    	}
    	
    	assertTrue(celdaAlEste3.getCuerpoActual() == null);
    	assertTrue(celdaAlOeste3.getCuerpoActual() == null);
    	assertTrue(celdaAlSur3.getCuerpoActual() == null);
    	assertTrue(celdaAlNorte3.getCuerpoActual() == null);
    }
    
    
    @Given ("^una Celda con un bomberman y un enemigo en la celda al \"([^\"]*)\"$")
    public void una_celda_con_un_bomberman_y_un_enemigo_en_la_celda_al(String dir) {
    	celdaCentral = new Celda();
    	bomberman = new Bomberman(celdaCentral);
    	celdaNueva = new Celda();
    	celdaCentral.setCeldaAl(dir, celdaNueva);
    	Enemigo enemy = new Enemigo(celdaNueva);
    }

    @Then("^la bomba explota y mata al enemigo$")
	public void la_bomba_explota_y_mata_al_enemigo(){
    	
    	celdaCentral.tick();
    	assertTrue (celdaNueva.getCuerpoActual() == null);
    }
    
    @Given ("^una Celda con un bomberman y una pared de acero en la celda al \"([^\"]*)\"$")
    public void una_celda_con_un_bomberman_y_una_pared_de_acero_en_la_celda_al(String dir){
    	celdaCentral = new Celda();
    	bomberman = new Bomberman(celdaCentral);
    	celdaNueva = new Celda();
    	celdaCentral.setCeldaAl(dir, celdaNueva);
    	Acero paredAcero = new Acero(celdaNueva);
    }
 	@Then ("^la bomba explota pero no rompe la pared$")
 	public void la_bomba_explora_pero_no_rompe_la_pared(){
 		celdaCentral.tick();
    	assertTrue (celdaNueva.getCuerpoActual() != null);
 	}
}
