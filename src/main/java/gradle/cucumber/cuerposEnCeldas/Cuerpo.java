package gradle.cucumber.cuerposEnCeldas;

import gradle.cucumber.Celda;

public abstract class Cuerpo {

	public Cuerpo (Celda celdaActual) {
		this.setCeldaActual(celdaActual);
		this.getCeldaActual().setCuerpoActual(this);
	}
	
	public Cuerpo() {	
	}

	public Celda celdaActual;

	public Celda getCeldaActual() {
		return celdaActual;
	}

	public void setCeldaActual(Celda celdaActual) {
		this.celdaActual = celdaActual;
		celdaActual.setCuerpoActual(this);
	}

	public abstract void serDestruido();
	
	public abstract void chocarConBomberman(Bomberman bomberman);

	protected abstract void serSaltadoPorBomberman(Bomberman bomberman, String dir);

	//la diferencia de este metodo con chocarConBomberman reside en que chocarConBomberman sucede cuando un bomberman se mueve hacia una celda,
	//cuando recibirBomberman sucede al caer un bomberman en la celda luego de saltar una pared.
	protected abstract void recibirBomberman(Bomberman bomberman, String dir);

	protected abstract void rebotarBomba(String dir, int ticks);

    protected abstract void setPoder(Ninguno ninguno);

    public abstract void dejarBomba(int parseInt);

	public abstract void dejarPoder(int parseInt);

    public void dejarBomba() {
    }

	public void dejarPoder() {
	}

	public void saltarPared() {
	}
}
