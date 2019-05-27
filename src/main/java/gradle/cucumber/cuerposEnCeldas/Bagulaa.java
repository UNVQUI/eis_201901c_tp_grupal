package gradle.cucumber.cuerposEnCeldas;

import gradle.cucumber.Celda;

public class Bagulaa extends Enemigo {

        public Bagulaa(Celda celdaActual) {
            super(celdaActual);
        }

        @Override
        public void serDestruido() {
            celdaActual.setCuerpoActual(null);
            this.getCeldaActual().setPoderActual(new LanzarBombas());
        }
    }


