package Bomberman;

public class Celda {

    private EstadoCelda estadoCelda;


    public Celda(){
        this.estadoCelda = new CeldaVacia();
    }

    public boolean estaVacia(){
        return estadoCelda.estaVacia();
    }
}
