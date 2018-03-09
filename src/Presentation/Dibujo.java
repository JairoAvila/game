package Presentation;


import logica.Bot;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class Dibujo extends JPanel {

    private static final int CLUSTER = 3;
    private static final int px = 10;
    private static final int py = 10;
    private static final int WIDTH = 140;
    private static final int HEIGHT = 140;
    private Rectangle2D[][] casillas = new Rectangle2D[CLUSTER][CLUSTER];
    private Color[][] color = new Color[CLUSTER][CLUSTER];
    private Boolean inicio=true;
    private Bot robot;

    public Dibujo() {
        this.setBounds(20,40,463,463);
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        if(inicio) {
            int x = px;
            int y = py;
            for (int i = 0; i < CLUSTER; i++) {
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
            inicio = false;
        /*Color blue = Color.white;
        if(blue.equals(color[0][0])){
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }*/
        }
        else
        {
            for (int i = 0; i < CLUSTER; i++) {
                for (int j = 0; j < CLUSTER; j++) {
                    int posx = (int) casillas[i][j].getX();
                    int posy = (int) casillas[i][j].getY();
                    int width = (int) casillas[i][j].getWidth();
                    int height = (int) casillas[i][j].getHeight();
                    g2.setColor(color[i][j]);
                    g2.fillRect(posx,posy,width,height);
                }
            }

            ImageIcon Img = new ImageIcon(getClass().getResource(getRobot().getImagen()));
            //g2.rotate(getRobot().angulos(getRobot().getDireccion()));
            g2.drawImage(Img.getImage(), getRobot().getPosisionX(), getRobot().getPosisionY() , null);
        }
    }

    public Rectangle2D[][] getCasilla() {
        return casillas;
    }

    public Color[][] getColor() {
        return color;
    }

    public void setColor(Color[][] color) {
        this.color = color;
    }

    public Bot getRobot() {
        return robot;
    }

    public void setRobot(Bot robot) {
        this.robot = robot;
    }
}
