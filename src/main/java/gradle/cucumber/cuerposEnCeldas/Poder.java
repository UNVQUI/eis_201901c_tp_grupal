package gradle.cucumber.cuerposEnCeldas;

public abstract class Poder{
	   
    public void darPoder (Bomberman bomberman) {
    	bomberman.setPoder(this);
    }
    
    public abstract void lanzarBomba(Bomberman bomberman, int cantCeldas, String dir, int ticks);
    
    public abstract void saltarPared(Bomberman bomberman, String dir);
    
    public abstract void lanzarNBombas(Bomberman bomberman, int cantCeldas, String dir, int ticks, int cantBombas);
}
