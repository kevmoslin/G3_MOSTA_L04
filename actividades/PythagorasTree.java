package actividades;
import java.awt.*;
import javax.swing.*;

public class PythagorasTree extends JPanel{ 
    private int profundidad;

    public PythagorasTree(int profundidad){
        this.profundidad = profundidad;
        setPreferredSize(new Dimension(800, 800));
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.GREEN);
        trazarArbol(g2d, 350, 600, 100, -90, profundidad);
    }
    
    private void trazarArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel){
        if (nivel == 0 || lado <2) {
            return;
        }

        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));

        g.drawLine(x, y, x2, y2);

        int nuevoLado = (int) (lado * 0.7);
        trazarArbol(g, x2, y2, nuevoLado, angulo-45, nivel-1);
        trazarArbol(g, x2, y2, nuevoLado, angulo+45, nivel-1);
    }

    public static void main(String[] args) {
        
        //Arbol de 3 niveles
        JFrame ventana = new JFrame("Arbol de Pitagoras de 3 niveles");
        PythagorasTree panel = new PythagorasTree(3);
        ventana.add(panel);
        ventana.setSize(800,800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        //arbol de 6 niveles
        JFrame ventana1 = new JFrame("Arbol de Pitagoras de 6 niveles");
        PythagorasTree panel1 = new PythagorasTree(6);
        ventana1.add(panel1);
        ventana1.setSize(800,800);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setVisible(true);
    }
}