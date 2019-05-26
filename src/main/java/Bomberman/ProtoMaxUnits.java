package Bomberman;

public class ProtoMaxUnits extends Enemigo {
        private Poder poder;

        public ProtoMaxUnits() {
            this.poder = new PoderSaltarYLanzar();
        }

        @Override
        public void explote(Celda celda, Juego juego) {
            celda.setItem(this.poder);
        }
    }