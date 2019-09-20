package AG;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Monalisa extends Thread {

    private ArrayList<Individuo> poblacion = new ArrayList<Individuo>();
    private ImageIcon destino;
    private int iteraciones;
    private JPanel panel;

    public Monalisa(ImageIcon destino, int iteraciones, JPanel panel) {
        this.destino = destino;
        this.iteraciones = iteraciones;
        this.panel = panel;
    }

    @Override
    public void run() {
        crearNuevaPoblacion();
    }

    private void crearNuevaPoblacion() {
        for (int i = 0; i < 300; i++) {//cuantos individuos tendremos
            poblacion.add(new Individuo(panel));
        }
    }

    public ArrayList<Individuo> getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(ArrayList<Individuo> poblacion) {
        this.poblacion = poblacion;
    }

    public ImageIcon getDestino() {
        return destino;
    }

    public void setDestino(ImageIcon destino) {
        this.destino = destino;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public void setIteraciones(int iteraciones) {
        this.iteraciones = iteraciones;
    }

}
