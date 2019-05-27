package gradle.cucumber.cuerposEnCeldas;

import gradle.cucumber.Celda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProtoMaxUnits extends Enemigo {

    public ProtoMaxUnits(Celda celdaActual) {
        super(celdaActual);
    }

    @Override
    public void serDestruido() {
        celdaActual.setCuerpoActual(null);
        dropearItemRandom();
    }

    public void dropearItemRandom(){
        Random rand = new Random();
        if (rand.nextBoolean()) {
        	this.getCeldaActual().setPoderActual(new SoltarVariasBombas());
        }
        else
        	{
        	this.getCeldaActual().setPoderActual(new SaltarParedes());
        }
    }
}
