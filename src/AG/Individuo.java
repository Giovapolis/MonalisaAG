package AG;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class Individuo {

    JPanel panel;
    private ArrayList<Figura> cromo = new ArrayList<Figura>();

    public Individuo(JPanel panel) {
        this.panel = panel;
        generarCromo();
    }

    public ArrayList<Figura> getCromo() {
        return cromo;
    }

    public void setCromo(ArrayList<Figura> cromo) {
        this.cromo = cromo;
    }

    public void generarCromo() {
        cromo.add( new Figura(
                new Point(new Random().nextInt(panel.getWidth()), new Random().nextInt(panel.getHeight())),//Agrega Coordenadas
                new Random().nextInt(panel.getWidth()),//Agrega Largo
                new Random().nextInt(panel.getHeight()),//Agrega Alto
                new Random().nextInt(255),//R
                new Random().nextInt(255),//G
                new Random().nextInt(255)//B
                )
        );
    }

    @Override
    public String toString() {
        return "Las figuras son: " + cromo;
    }
}
