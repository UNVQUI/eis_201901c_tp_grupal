package Bomberman;

public class ProtoMaxUnits extends Enemigo {
        private Poder poder;

        public ProtoMaxUnits() {
            this.poder = new PoderSaltarYLanzar();
        }

        @Override
        public void explote(Celda celda, Juego juego) {
            juego.darPoderABomberman(this.poder);
            celda.setItem(new Vacio());
        }
    }