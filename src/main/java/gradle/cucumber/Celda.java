package gradle.cucumber;

import gradle.cucumber.cuerposEnCeldas.Bomba;
import gradle.cucumber.cuerposEnCeldas.Bomberman;
import gradle.cucumber.cuerposEnCeldas.Cuerpo;
import gradle.cucumber.cuerposEnCeldas.Poder;

public class Celda {
    private Cuerpo cuerpoActual;
    private Bomba bombaActual;
    private Poder poderActual;
    private Celda celdaAlNorte;
    private Celda celdaAlSur;
    private Celda celdaAlEste;
    private Celda celdaAlOeste;

	public Celda getCeldaAlSur() {
		return celdaAlSur;
	}

	public void setCeldaAlSur(Celda celdaAlSur) {
		this.celdaAlSur = celdaAlSur;
	}


	public Celda getCeldaAlEste() {
		return celdaAlEste;
	}


	public void setCeldaAlEste(Celda celdaAlEste) {
		this.celdaAlEste = celdaAlEste;
	}


	public Celda getCeldaAlNorte() {
		return celdaAlNorte;
	}


	public void setCeldaAlNorte(Celda celdaAlNorte) {
		this.celdaAlNorte = celdaAlNorte;
	}


	public Celda getCeldaAlOeste() {
		return celdaAlOeste;
	}


	public void setCeldaAlOeste(Celda celdaAlOeste) {
		this.celdaAlOeste = celdaAlOeste;
	}

	public void setCeldaAl(String dir, Celda celda) {
			switch(dir) {
	  	  case "Sur":
	  		  this.setCeldaAlSur(celda);
	  		  celda.setCeldaAlNorte(this);
	  	    break;
	  	  case "Norte":
	  		  this.setCeldaAlNorte(celda);
	  		  celda.setCeldaAlSur(this);
	  	    break;
	  	  case "Este":
	  		  this.setCeldaAlEste(celda);
	  		  celda.setCeldaAlOeste(this);
	    	    break;
	  	  case "Oeste":
	  		  this.setCeldaAlOeste(celda);
	  		  celda.setCeldaAlEste(this);
	    	    break;
	  	}
	}
	
	public Celda getCeldaAl(String dir) {
		switch(dir) {
	  	  case "Sur":
	  		 if (this.getCeldaAlSur() != null) return this.getCeldaAlSur();
	  	    break;
	  	  case "Norte":
	  		 if (this.getCeldaAlNorte() != null) return this.getCeldaAlNorte();
	  	    break;
	  	  case "Este":
	  		 if (this.getCeldaAlEste() != null) return this.getCeldaAlEste();
	    	    break;
	  	  case "Oeste":
	  		 if (this.getCeldaAlOeste() != null) return this.getCeldaAlOeste();
	    	    break;
	  	}
		return null;
	}


	public Cuerpo getCuerpoActual() {
		return cuerpoActual;
	}


	public void setCuerpoActual(Cuerpo cuerpoActual) {
		this.cuerpoActual = cuerpoActual;
	}


	public Bomba getBombaActual() {
		return bombaActual;
	}


	public void setBombaActual(Bomba bombaActual) {
		this.bombaActual = bombaActual;
	}


	public void tick() {
		this.bombaActual.restarTick();
	}


	public void destruirObjeto() {
		if(this.getCuerpoActual() != null) {
		this.getCuerpoActual().serDestruido();
		}
	}

	public void ondaExpansiva(String dir, int alcanceFaltante) {
		if (alcanceFaltante > 0) {
			switch(dir) {
		  	  case "Sur":
		  		  if (this.getCeldaAlSur() != null) this.getCeldaAlSur().ondaExpansiva("Sur", alcanceFaltante - 1);
		  	    break;
		  	  case "Norte":
		  		if (this.getCeldaAlNorte() != null) this.getCeldaAlNorte().ondaExpansiva("Norte", alcanceFaltante - 1);
		  	    break;
		  	  case "Este":
		  		if (this.getCeldaAlEste() != null) this.getCeldaAlEste().ondaExpansiva("Este", alcanceFaltante - 1);
		    	    break;
		  	  case "Oeste":
		  		if (this.getCeldaAlOeste() != null) this.getCeldaAlOeste().ondaExpansiva("Oeste", alcanceFaltante - 1);
		    	    break;
			}
		}
		this.destruirObjeto();
	}

	public void recibirBomberman(Bomberman bomberman, Celda celda) {
		if (this.getCuerpoActual() == null) {
			this.setCuerpoActual(bomberman);
			bomberman.setCeldaActual(this);
			celda.setCuerpoActual(null);
			if (this.getPoderActual() != null) {
				bomberman.setPoder(this.getPoderActual());
				this.setPoderActual(null);
			}
		}
		else
		{
		this.cuerpoActual.chocarConBomberman(bomberman);
		}
	}

	public Poder getPoderActual() {
		return poderActual;
	}

	public void setPoderActual(Poder poderActual) {
		this.poderActual = poderActual;
	}
}

// codigo a borrar

/*
*

	public boolean sePuedeMoverAca() {
		if (cuerpoActual == null){
			return true;
		} else
		{
		 return cuerpoActual.sePuedeAtravezar();
    }}
* */