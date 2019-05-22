package Bomberman;

public class Celda {

    private Item item;

    public Celda(){
        this.item = new Vacio();
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void moverABomberman(Juego juego, Coordinate hacia) {
        this.item.bombermanSeMueve(juego, hacia);
    }

    public Item getItem() {
        return item;
    }
}
