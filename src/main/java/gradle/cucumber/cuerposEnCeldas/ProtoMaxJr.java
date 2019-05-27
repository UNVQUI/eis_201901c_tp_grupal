package gradle.cucumber.cuerposEnCeldas;

import gradle.cucumber.Celda;


public class ProtoMaxJr extends Enemigo {

    private Poder poder;
    private boolean estavivo;

    public ProtoMaxJr (Celda celdaActual) {
        super(celdaActual);
        this.setPoder(new Ninguno());
        this.estavivo = true;
    }

    @Override
    public void serDestruido() {
        celdaActual.setCuerpoActual(null);
        getCeldaActual().setPoderActual(new SaltarParedes());

    }

    @Override
    public void chocarConBomberman(Bomberman bomberman) {

    }

    @Override
    protected void serSaltadoPorBomberman(Bomberman bomberman, String dir) {

    }

    @Override
    protected void recibirBomberman(Bomberman bomberman, String dir) {

    }

    @Override
    protected void rebotarBomba(String dir, int ticks) {

    }

    public void setPoder(Poder ninguno) {

    }

    public void dejarBomba(int parseInt) {

    }

    public void dejarPoder(int parseInt) {

    }

}
