package gradle.cucumber.cuerposEnCeldas;

import gradle.cucumber.Celda;


public class Enemigo extends Cuerpo {

    public Enemigo(Celda celdaActual) {
        super(celdaActual);
    }

    @Override
    public void serDestruido() {
    	this.getCeldaActual().setCuerpoActual(null);
    }

	@Override
	public void chocarConBomberman(Bomberman bomberman) {
		bomberman.muere();
	}

	@Override
	protected void serSaltadoPorBomberman(Bomberman bomberman, String dir) {
	}

	@Override
	protected void recibirBomberman(Bomberman bomberman, String dir) {
		bomberman.muere();
	}

	@Override
	protected void rebotarBomba(String dir, int ticks) {
		this.getCeldaActual().setBombaActual(new Bomba(ticks, this.getCeldaActual()));
	}

	@Override
	protected void setPoder(Ninguno ninguno) {

	}

	@Override
	public void dejarBomba(int parseInt) {

	}

	@Override
	public void dejarPoder(int parseInt) {

	}

}
