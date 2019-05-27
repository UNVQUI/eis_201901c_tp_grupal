package gradle.cucumber.cuerposEnCeldas;

import gradle.cucumber.Celda;

public class Acero extends Pared {

	public Acero(Celda celdaActual) {
		super(celdaActual);
	}

	@Override
	public void serDestruido() {}

	@Override
	public void chocarConBomberman(Bomberman bomberman) {}

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
