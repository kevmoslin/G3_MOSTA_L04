package actividades;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

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
    
}