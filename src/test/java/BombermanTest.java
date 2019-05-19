import Bomberman.*;
import junit.framework.TestCase;
import org.junit.Test;

public class BombermanTest extends TestCase {
    @Test
    public void testWhenBombermanInCoordinate1x1yMovesToTheNorthenCellHisNewCoordinateIs1x2y(){
        Bomberman bomberman = new Bomberman();

        bomberman.move(new North());

        assertEquals(bomberman.getCoordinate(),new Coordinate(1,2));
    }
    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheSouthernCellHisNewCoordinateIs1x0y(){
        Bomberman bomberman = new Bomberman();

        bomberman.move(new South());

        assertEquals(bomberman.getCoordinate(),new Coordinate(1,0));
    }
    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheEasternCellHisNewCoordinateIs2x1y(){
        Bomberman bomberman = new Bomberman();

        bomberman.move(new East());

        assertEquals(bomberman.getCoordinate(),new Coordinate(2,1));
    }
    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheWesternCellHisNewCoordinateIs0x1y(){
        Bomberman bomberman = new Bomberman();

        bomberman.move(new West());

        assertEquals(bomberman.getCoordinate(),new Coordinate(0,1));
    }

}
