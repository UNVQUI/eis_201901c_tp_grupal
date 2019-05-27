package gradle.cucumber.cuerposEnCeldas;

public class SaltarParedes extends Poder {

	//Este poder puede saltar una o mas paredes contiguas. Bomberman solo saltara cuando se encuentra junto a la pared que desea saltar.
	@Override
	public void lanzarBomba(Bomberman bomberman, int cantCeldas, String dir, int ticks) {}

	@Override
	public void saltarPared(Bomberman bomberman, String dir) {
		if (bomberman.getCeldaActual().getCeldaAl(dir).getCuerpoActual() != null)
		bomberman.getCeldaActual().getCeldaAl(dir).getCuerpoActual().serSaltadoPorBomberman(bomberman,dir);
	}

	@Override
	public void lanzarNBombas(Bomberman bomberman, int cantCeldas, String dir, int ticks, int cantBombas) {}
}
