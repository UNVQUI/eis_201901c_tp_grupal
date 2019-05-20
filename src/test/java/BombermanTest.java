import Bomberman.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class BombermanTest extends TestCase {

    private Mapa mapa;
    @Before
    public void setUp(){

        this.mapa = new Mapa();

    }

    @Test
    public void testWhenBombermanInCoordinate1x1yMovesToTheNorthenCellHisNewCoordinateIs1x2y(){

        mapa.moverBomberman(new North());

        assertEquals(mapa.getPosicionBomberman(),new Coordinate(1,2));
    }


    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheSouthernCellHisNewCoordinateIs1x0y(){
        mapa.moverBomberman(new South());

        assertEquals(mapa.getPosicionBomberman(),new Coordinate(1,0));
    }
    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheEasternCellHisNewCoordinateIs2x1y(){
        mapa.moverBomberman(new East());

        assertEquals(mapa.getPosicionBomberman(),new Coordinate(2,1));
    }
    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheWesternCellHisNewCoordinateIs0x1y(){

        mapa.moverBomberman(new West());

        assertEquals(mapa.getPosicionBomberman(),new Coordinate(0,1));
    }

}
