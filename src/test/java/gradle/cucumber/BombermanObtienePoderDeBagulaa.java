package gradle.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gradle.cucumber.cuerposEnCeldas.Bomberman;
import gradle.cucumber.cuerposEnCeldas.LanzarBombas;
import gradle.cucumber.cuerposEnCeldas.Melamina;
import gradle.cucumber.cuerposEnCeldas.Ninguno;
import gradle.cucumber.cuerposEnCeldas.Bagulaa;

import static junit.framework.TestCase.assertTrue;


public class BombermanObtienePoderDeBagulaa {

        Bomberman bomberman;
        Bagulaa bagulaa;
        Celda celdaActual = new Celda();
        Celda celdaSur = new Celda();
        Celda celdaNorte = new Celda();
        Melamina pared ;

        @Given("^Bomberman tiene a Bagulaa en una celda al \"([^\"]*)\" de la que se encuentra$")
        public void bombermanTieneABagulaaEnUnaCeldaAlDeLaQueSeEncuentra(String arg0)  {
            bomberman = new Bomberman(celdaActual);
            bagulaa = new Bagulaa(celdaNorte);
            celdaActual.setCeldaAlSur(celdaSur);
            celdaActual.setCeldaAl(arg0 , celdaNorte);
            celdaSur.setCeldaAlNorte(celdaActual);

        }

        @When("^Bomberman deja una bomba \"([^\"]*)\" ticks y se mueve al \"([^\"]*)\"$")
        public void bombermanDejaUnaBombaTicksYSeMueveAl(String arg0, String arg1) {
            bomberman.dejarBomba(Integer.parseInt(arg0));
            bomberman.moverAl(arg1);
        }

        @Then("^Explota la bomba y muere Bagulaa \\. Bomberman obtiene el Poder$")
        public void explotaLaBombaYMuereBagulaaBombermanObtieneElPoder() {
            assertTrue(celdaNorte.getCuerpoActual().getClass() == Bagulaa.class);
            assertTrue (celdaActual.getBombaActual() != null);

            //Por ahora esta es mi unica forma de hacer explotar una bomba
            for (int i =2; i >= 0; i--) {
                celdaActual.tick();
            }


            assertTrue(celdaNorte.getCuerpoActual() == null);
            assertTrue(celdaActual.getBombaActual() == null);
            assertTrue(bomberman.getPoder().getClass() == Ninguno.class );

            bomberman.moverAl("Norte");
            bomberman.moverAl("Norte");

            assertTrue(bomberman.getPoder().getClass() == LanzarBombas.class );
            assertTrue(bomberman.getCeldaActual() == celdaNorte);
        }

        @Given("^Bomberman quiere romper una pared de melamina que se encuentra a (\\d+) celdas de distancia$")
        public void bombermanQuiereRomperUnaParedDeMelaminaQueSeEncuentraACeldasDeDistancia(int arg0) {
            bomberman = new Bomberman(celdaSur);
            pared = new Melamina(celdaNorte);
            celdaActual.setCeldaAlSur(celdaSur);
            celdaActual.setCeldaAlNorte(celdaNorte);
            celdaSur.setCeldaAlNorte(celdaActual);
            bomberman.setPoder(new LanzarBombas());
        }

        @When("^Bomberman lanza una bomba \"([^\"]*)\" ticks en direccion \"([^\"]*)\" a \"([^\"]*)\" celda de Distanica$")
        public void bombermanLanzaUnaBombaTicksEnDireccionACeldaDeDistanica(String ticks, String dir, String dist) {
            bomberman.lanzarBomba(Integer.parseInt(dist) , dir , Integer.parseInt(ticks));
        }



        @Then("^La bomba explota y La pared de Melamina que se encontraba (\\d+) celdas de distancia se destruyo$")
        public void laBombaExplotaYLaParedDeMelaminaQueSeEncontrabaCeldasDeDistanciaSeDestruyo(int arg0) {

            assertTrue(celdaNorte.getCuerpoActual().getClass() == Melamina.class);
            assertTrue (celdaActual.getBombaActual() != null);

            //Exploto la bomba lanzada
            //Por ahora esta es mi unica forma de hacer explotar una bomba
            for (int i =2; i >= 0; i--) {
                celdaActual.tick();
            }

            assertTrue (celdaActual.getBombaActual() == null);
            assertTrue(celdaNorte.getCuerpoActual() == null);
        }


    }


