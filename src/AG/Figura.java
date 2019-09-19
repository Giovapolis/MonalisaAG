package AG;

import java.awt.Point;

public class Figura{
    private Point coordenadas;
    private int largo;
    private int alto;
    private int rojo;
    private int verde;
    private int azul;

    public Figura(Point coordenadas, int largo, int alto, int rojo, int verde, int azul) {
        this.coordenadas = coordenadas;
        this.largo = largo;
        this.alto = alto;
        this.rojo = rojo;
        this.verde = verde;
        this.azul = azul;
    }

    public int getAzul() {
        return azul;
    }

    public void setAzul(int azul) {
        this.azul = azul;
    }

    public Point getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Point coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getRojo() {
        return rojo;
    }

    public void setRojo(int rojo) {
        this.rojo = rojo;
    }

    public int getVerde() {
        return verde;
    }

    public void setVerde(int verde) {
        this.verde = verde;
    }

    @Override
    public String toString() {
        return "[x="+coordenadas.x+ ",y="+ coordenadas.y  + "], largo=" + largo + ", alto=" + alto + ", rojo=" + rojo + ", verde=" + verde + ", azul=" + azul + '}';
    }
}
