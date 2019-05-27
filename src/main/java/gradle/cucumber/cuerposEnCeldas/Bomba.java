package gradle.cucumber.cuerposEnCeldas;

import gradle.cucumber.Celda;

public class Bomba{
	
	private int ticks;
	private Celda celdaActual;

	private int getTicks() {
		return ticks;
	}

	private void setTicks(int ticks) {
		this.ticks = ticks;
	}
	
	public Bomba (int ticks, Celda celda) {
		this.ticks = ticks;
		this.celdaActual = celda;
	}

	public void restarTick() {
		this.ticks--;
		if (this.ticks <= 0) {
			this.explotar();
		}
	}

	private void explotar() {
		this.getCeldaActual().setBombaActual(null);
		celdaActual.ondaExpansiva("Norte",3);
		celdaActual.ondaExpansiva("Sur",3);
		celdaActual.ondaExpansiva("Este",3);
		celdaActual.ondaExpansiva("Oeste",3);
	}

	public Celda getCeldaActual() {
		return celdaActual;
	}

	public void setCeldaActual(Celda celdaActual) {
		this.celdaActual = celdaActual;
	}
}
