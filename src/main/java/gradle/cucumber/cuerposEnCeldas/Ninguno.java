package gradle.cucumber.cuerposEnCeldas;

public class Ninguno extends Poder {

	@Override
	public void darPoder(Bomberman bomberman) {}

	@Override
	public void saltarPared(Bomberman bomberman, String dir) {}

	@Override
	public void lanzarBomba(Bomberman bomberman, int cantCeldas, String dir, int ticks) {}

	@Override
	public void lanzarNBombas(Bomberman bomberman, int cantCeldas, String dir, int ticks, int cantBombas) {}

}
