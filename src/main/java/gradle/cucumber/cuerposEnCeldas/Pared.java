package gradle.cucumber.cuerposEnCeldas;

import gradle.cucumber.Celda;

public abstract class Pared extends Cuerpo {
    
	public Pared(Celda celdaActual) {
        super(celdaActual);
    }

    public boolean sePuedeAtravezar(Bomberman bomberman){
        return false;
    }
    
    public void serSaltadoPorBomberman(Bomberman bomberman, String dir) {
    	String direccionOpuesta = "";
    	switch(dir) {
	  	  case "Sur":
	  		 direccionOpuesta = "Norte";
	  	    break;
	  	  case "Norte":
	  		direccionOpuesta = "Sur";
	  	    break;
	  	  case "Este":
	  		direccionOpuesta = "Oeste";
    	    break;
	  	  case "Oeste":
	  		direccionOpuesta = "Este";
    	    break;
	  	}
    	if (this.celdaActual.getCeldaAl(dir).getCuerpoActual() == null) {
    		this.celdaActual.getCeldaAl(direccionOpuesta).setCuerpoActual(null);
    		this.celdaActual.getCeldaAl(dir).setCuerpoActual(bomberman);
    		if (this.getCeldaActual().getPoderActual() != null) {
    			bomberman.setPoder(this.getCeldaActual().getPoderActual());
    		}
    	}
    	else {
    		this.celdaActual.getCeldaAl(dir).getCuerpoActual().recibirBomberman(bomberman, dir);
    	}	
    }
    
    public void recibirBomberman(Bomberman bomberman, String dir) {
    	this.serSaltadoPorBomberman(bomberman, dir);
    }
    
    public void rebotarBomba (String dir, int ticks) {
    	if (this.getCeldaActual().getCeldaAl(dir).getCuerpoActual() == null) {
    		this.getCeldaActual().getCeldaAl(dir).setBombaActual(new Bomba(ticks, this.getCeldaActual().getCeldaAl(dir)));
    	}
    	else {
    		this.getCeldaActual().getCeldaAl(dir).getCuerpoActual().rebotarBomba(dir, ticks);
    	}
    }
}
