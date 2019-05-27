package gradle.cucumber.cuerposEnCeldas;

import gradle.cucumber.Celda;

public class LanzarBombas extends Poder {

	//Este poder lanza una bomba creada al momento de lanzarse hacia la direccion indicada la cantidad de celdas indicadas.
	
	@Override
	public void lanzarBomba(Bomberman bomberman, int cantCeldas, String dir, int ticks) {
		Celda celdaFinal = bomberman.getCeldaActual();
		for (int i = 1; i <= cantCeldas; i++) {
			celdaFinal = celdaFinal.getCeldaAl(dir);
		}
		if (celdaFinal.getCuerpoActual() == null) {
			celdaFinal.setBombaActual(new Bomba(ticks, celdaFinal));
		}
		else {
			celdaFinal.getCuerpoActual().rebotarBomba(dir, ticks);
		}
	}

	@Override
	public void saltarPared(Bomberman bomberman, String dir) {}

	@Override
	public void lanzarNBombas(Bomberman bomberman, int cantCeldas, String dir, int ticks, int cantBombas) {}
    
}
