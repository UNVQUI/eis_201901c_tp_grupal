package Bomberman;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

    //MAPA TIENE QUE POSEER POR LO MENOS 1 CELDA

    private Coordinate posicionBomberman;
    private List<List<Celda>> mapa; //Lista de Celdas

    //Crea un mapa por default de 5x5 con todas las celdas vacias
    public Mapa(){
        this.mapa = this.crearUnMapa(5,5);
        this.posicionBomberman = new Coordinate(1,1);
    }

    private List<List<Celda>> crearUnMapa(int largo,int alto){

        List<List<Celda>> mapaEnCreacion = new ArrayList<List<Celda>>();


        for(int l=0; l < largo;l++) {

            List<Celda> columna = new ArrayList<Celda>();

            this.crearCeldasDeColumna(columna,alto);

            mapaEnCreacion.add(columna);

        }

        return mapaEnCreacion;
    }

    private void crearCeldasDeColumna(List<Celda> columna,int alto){
        for(int i=0; i < alto; i++) {
            columna.add(new Celda());
        }
    }

    public Celda getCelda(Coordinate c){
        int longitud = c.getX();
        int altura = c.getY();
        return this.mapa.get(longitud).get(altura);
    }

    public Celda getCeldaBomberman(){
        return this.getCelda(this.posicionBomberman);
    }

    public void moverBomberman(Direction dir){

        Coordinate nextCoord = dir.giveNextCoordinate(this.posicionBomberman);
        if(this.getCelda(nextCoord).estaVacia()){
            this.posicionBomberman = nextCoord;
        }

    }

    public Coordinate getPosicionBomberman(){
        return this.posicionBomberman;
    }
}
