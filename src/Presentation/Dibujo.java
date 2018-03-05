package Presentation;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Dibujo extends JPanel {

    private static final int CLUSTER = 3;
    private static final int px = 10;
    private static final int py = 10;
    private static final int WIDTH = 140;
    private static final int HEIGHT = 140;
    private Rectangle2D[][] casillas = new Rectangle2D[CLUSTER][CLUSTER];
    private Color[][] color = new Color[CLUSTER][CLUSTER];
    private int xcircle = 0;
    private int ycircle = 0;

    public Dibujo() {
        this.setBounds(20,40,463,463);
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        int x = px;
        int y = py;
        for(int i = 0; i < CLUSTER; i++) {
            for (int j = 0; j < CLUSTER; j++) {
                g2.setPaint(Color.white);
                casillas[i][j] = new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
                color[i][j] = g2.getColor();
                g2.fill(casillas[i][j]);
                g2.getColor();
                x = x + WIDTH + 10;
            }
            x = px;
            y = y + HEIGHT + 10;
        }

        int xx = (int) casillas[xcircle][ycircle].getCenterX();
        int yy = (int) casillas[xcircle][ycircle].getCenterY();
        g.setColor(Color.yellow);
        g.fillRect(xx, yy, 50, 50);
        /*Color blue = Color.white;
        if(blue.equals(color[0][0])){
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }*/
    }

    public void setXcircle(int xcircle) {
        this.xcircle = xcircle;
    }

    public void setYcircle(int ycircle) {
        this.ycircle = ycircle;
    }

    public Rectangle2D[][] getCasilla() {
        return casillas;
    }

    public Color[][] getColor() {
        return color;
    }
}
