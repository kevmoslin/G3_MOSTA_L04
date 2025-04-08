package actividades;
import javax.swing.*;

public class main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Arbol de Pitagoras");
        PythagorasTree panel = new PythagorasTree(0);
        ventana.add(panel);
        ventana.setSize(800,800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
