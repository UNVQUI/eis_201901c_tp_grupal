import Bomberman.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class MoviemientoBombermanTest extends TestCase {
    private Mapa mapa;
    private Juego juego;
    @Before
    public void setUp(){

        this.juego = new Juego();
        this.mapa = this.juego.getMapa();

    }

    @Test
    public void testBombermanMuereAlMoverseAlNorteHabiendoEnemigo(){

        Direction direction = new North();

        Coordinate posicionBomberman = this.juego.getPosicionBomberman();
        Coordinate coordendaAlNorte = direction.giveNextCoordinate(posicionBomberman);

        this.mapa.colocarItem(new Enemigo(), coordendaAlNorte);
        this.juego.moverBomberman(direction);

        assertEquals(true, this.juego.getBomberman().siEstaMuerto());
    }
}
