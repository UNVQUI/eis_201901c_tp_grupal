import Bomberman.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class BombermanTest extends TestCase {

    private Juego juego;
    @Before
    public void setUp(){

        this.juego = new Juego();

    }

    @Test
    public void testWhenBombermanInCoordinate1x1yMovesToTheNorthenCellHisNewCoordinateIs1x2y() throws Exception{

        this.juego.moverBomberman(new North());

        assertEquals(this.juego.getPosicionBomberman(),new Coordinate(1,2));
    }


    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheSouthernCellHisNewCoordinateIs1x0y() throws Exception{
        this.juego.moverBomberman(new South());

        assertEquals(this.juego.getPosicionBomberman(),new Coordinate(1,0));
    }
    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheEasternCellHisNewCoordinateIs2x1y() throws Exception{
        this.juego.moverBomberman(new East());

        assertEquals(this.juego.getPosicionBomberman(),new Coordinate(2,1));
    }
    @Test
    public void testWhenBombermanInCoordinate1x1MovesToTheWesternCellHisNewCoordinateIs0x1y() throws Exception{

        this.juego.moverBomberman(new West());

        assertEquals(this.juego.getPosicionBomberman(),new Coordinate(0,1));
    }
    @Test
    public void testBombermanSueltaUnaBombaYMataAProtoMaxYAhoraBombermanSaltaUnaPardDeMetal() throws Exception{
        Enemigo protoMaxJr = new ProtoMaxJr();
        Coordinate posicionViejaDeBomberman = juego.getPosicionBomberman();
        Coordinate coordenadaAlNorteDeBomberman = new North().giveNextCoordinate(posicionViejaDeBomberman);
        Coordinate coordenadaAlSurDeBomberman = new South().giveNextCoordinate(posicionViejaDeBomberman);

        juego.getMapa().colocarItem(protoMaxJr,coordenadaAlNorteDeBomberman);

        juego.bombermanDejaUnaBomba();
        juego.getMapa().colocarItem(new ParedAcero(),coordenadaAlSurDeBomberman);
        juego.correnNTicks(4);

        juego.moverBomberman(new South());

        assertEquals(juego.getPosicionBomberman(),coordenadaAlSurDeBomberman);
        assertTrue(juego.getMapa().getCelda(coordenadaAlNorteDeBomberman).estaVacio());
    }

    @Test
    public void testBombermanSueltaUnaBombaYMataAProtoMaxYAhoraBombermanPuedeSaltarParedes()throws Exception{
        Enemigo protoMaxUnits = new ProtoMaxUnits();
        Enemigo enemigo = new Enemigo();
        Coordinate posicionViejaDeBomberman = juego.getPosicionBomberman();
        Coordinate coordenadaAlNorteDeBomberman = new North().giveNextCoordinate(posicionViejaDeBomberman);
        Coordinate coordenadaAlSurDeBomberman = new South().giveNextCoordinate(posicionViejaDeBomberman);

        juego.getMapa().colocarItem(protoMaxUnits,coordenadaAlNorteDeBomberman);

        juego.bombermanDejaUnaBomba();
        juego.getMapa().colocarItem(new ParedAcero(),coordenadaAlSurDeBomberman);
        juego.correnNTicks(4);

        juego.moverBomberman(new South());

        assertEquals(juego.getPosicionBomberman(),coordenadaAlSurDeBomberman);
        assertTrue(juego.getMapa().getCelda(coordenadaAlNorteDeBomberman).estaVacio());

    }


    @Test
    public void testBombermanSueltaUnaBombaYMataAProtoMaxYAhoraBombermanPuedeLanzarBombasYMataUnEnemigoLanzandoleUnaBombaAlNorte() throws Exception{
        Enemigo protoMaxUnits = new ProtoMaxUnits();
        Enemigo enemigo = new Enemigo();
        Coordinate posicionBomberman = juego.getPosicionBomberman();
        Coordinate coordenadaAlNorteDeBomberman = new North().giveNextCoordinate(posicionBomberman);
        Coordinate coordenadaAlSurDebomberman = new South().giveNextCoordinate(posicionBomberman);

        //Obtiene el mapa y le pone a ProtoMaxUnits al norte de la celda actual de bomberman, luego coloca una bomba en la ubicacion actual de BomberMan
        juego.getMapa().colocarItem(protoMaxUnits,coordenadaAlNorteDeBomberman);
        juego.bombermanDejaUnaBomba();
        //Explota la bomba al correr los 4 ticks
        juego.correnNTicks(4);
        //Coloca un enemigo al Sur de bomberman, y lanza una bomba que anteriormente obtuvo el poder al matar a ProtoMaxUnits
        juego.getMapa().colocarItem(enemigo,coordenadaAlSurDebomberman);
        juego.setDondeMiraBomberman(new South());
        juego.bombermanLanzaUnaBomba(1,3);
        juego.correnNTicks(3);

        //Verifica que ProtoMaxUnits haya muerto(en el norte) y el enemigo tambien (en el sur)
        assertTrue(juego.getMapa().getCelda(coordenadaAlSurDebomberman).estaVacio());
        assertTrue(juego.getMapa().getCelda(coordenadaAlNorteDeBomberman).estaVacio());
    }

    @Test
    public void testBombermanSueltaUnaBombaYMataAProtoMaxYAhoraBombermanPuedeLanzarBombas() throws Exception{
        Enemigo protoMaxUnits = new ProtoMaxUnits();
        Enemigo enemigo = new Enemigo();
        Coordinate posicionViejaDeBomberman = juego.getPosicionBomberman();
        Coordinate coordenadaAlNorteDeBomberman = new North().giveNextCoordinate(posicionViejaDeBomberman);

        juego.getMapa().colocarItem(protoMaxUnits,coordenadaAlNorteDeBomberman);
        juego.bombermanDejaUnaBomba();
        juego.correnNTicks(4);
        juego.getMapa().colocarItem(enemigo,coordenadaAlNorteDeBomberman);
        juego.setDondeMiraBomberman(new North());
        juego.bombermanLanzaUnaBomba(1,3);
        juego.correnNTicks(3);

        assertTrue(juego.getMapa().getCelda(coordenadaAlNorteDeBomberman).estaVacio());
    }

}
