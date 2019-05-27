package gradle.cucumber.cuerposEnCeldas;

import gradle.cucumber.Celda;

import java.util.List;

public class Bomberman extends Cuerpo{
	
	private Poder poder;
	private boolean estavivo;

	public Bomberman(Celda celdaActual) {
		super(celdaActual);
		this.setPoder(new Ninguno());
		this.estavivo = true;
	}


	@Override
	public void serDestruido() {
		celdaActual.setCuerpoActual(null);
	}

    public void moverAl(String dir) {
    	switch(dir) {
    	  case "Sur":
    		  if (this.getCeldaActual().getCeldaAlSur() != null) this.getCeldaActual().getCeldaAlSur().recibirBomberman(this, this.getCeldaActual());
    	    break;
    	  case "Norte":
    		  if (this.getCeldaActual().getCeldaAlNorte() != null) this.getCeldaActual().getCeldaAlNorte().recibirBomberman(this, this.getCeldaActual());
    	    break;
    	  case "Este":
    		  if (this.getCeldaActual().getCeldaAlEste() != null) this.getCeldaActual().getCeldaAlEste().recibirBomberman(this, this.getCeldaActual());
      	    break;
    	  case "Oeste":
    		  if (this.getCeldaActual().getCeldaAlOeste() != null) this.getCeldaActual().getCeldaAlOeste().recibirBomberman(this, this.getCeldaActual());
      	    break;
    	}
    }
	
	public void dejarBomba(int ticks) {
		this.getCeldaActual().setBombaActual(new Bomba(ticks, this.getCeldaActual()));
	}

	@Override
	public void dejarPoder(int parseInt) {

	}

	public void muere() {
        estavivo = false;
        celdaActual.setCuerpoActual(null);
	}

	public Boolean getEstavivo() {
		return estavivo;
	}

	public void setEstavivo(Boolean estavivo) {
		this.estavivo = estavivo;
	}

	@Override
	public void chocarConBomberman(Bomberman bomberman) {}

	@Override
	protected void serSaltadoPorBomberman(Bomberman bomberman, String dir) {}

	@Override
	protected void recibirBomberman(Bomberman bomberman, String dir) {}

	public void saltarPared(String dir) {
		this.getPoder().saltarPared(this, dir);
	}
	
	public void lanzarBomba(int cantCeldas, String dir, int ticks) {
		this.getPoder().lanzarBomba(this, cantCeldas, dir, ticks);
	}
	
	public void soltarVariasBombas(int cantCeldas, String dir, int ticks, int cantBombas) {
		this.getPoder().lanzarNBombas(this, cantCeldas, dir, ticks, cantBombas);
	}

	public Poder getPoder() {
		return poder;
	}

	public void setPoder(Poder poder) {
		this.poder = poder;
	}

	@Override
	protected void rebotarBomba(String dir, int ticks) {}

	@Override
	protected void setPoder(Ninguno ninguno) {
		poder = ninguno;
	}
}
