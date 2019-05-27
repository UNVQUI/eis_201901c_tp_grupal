package gradle.cucumber.cuerposEnCeldas;

public class SoltarVariasBombas extends Poder {
	
	/*Se decidio que este poder funcione de la siguiente manera: 	
	 * 	- Se selecciona la direccion hacia la cual se lanzan las bombas.															
		- La cantidad de celdas que indican la distancia de la primer bomba a lanzarse.
		- Los ticks que tardaran en explotar las bombas lanzadas.
		- Y la cantidad de bombas, que se iran lanzando una tras otra hacia la direccion indicada avanzando de a una celda por lanzamiento.
	 */

	@Override
	public void lanzarBomba(Bomberman bomberman, int cantCeldas, String dir, int ticks) {}

	@Override
	public void saltarPared(Bomberman bomberman, String dir) {}

	@Override
	public void lanzarNBombas(Bomberman bomberman, int cantCeldas, String dir, int ticks, int cantBombas) {
		LanzarBombas lanzaBombas = new LanzarBombas();
		for (int i = 0; i<=cantBombas; i++) {
			lanzaBombas.lanzarBomba(bomberman, cantCeldas + i, dir, ticks);
		}
	}
}
