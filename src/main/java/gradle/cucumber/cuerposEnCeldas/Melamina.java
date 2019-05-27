package gradle.cucumber.cuerposEnCeldas;

import gradle.cucumber.Celda;

public class Melamina extends Pared{
	public Melamina(Celda celdaActual) {
		super(celdaActual);
	}


	/*public Melamina(Celda celdaActual) {
		this.setCeldaActual(celdaActual);
		this.getCeldaActual().setCuerpoActual(this);
	}*/

	@Override
	public void serDestruido() {
		this.getCeldaActual().setCuerpoActual(null);
	}


	@Override
	public void chocarConBomberman(Bomberman bomberman) {
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
