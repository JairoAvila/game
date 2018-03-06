package Presentation;

import logica.Tablero;
import logica.Bot;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class model {
    private View ventanaPrincipal;
    private Tablero tablero;
    private Bot bot;

    public View getVentanaPrincipal() {
        if(ventanaPrincipal == null){
            ventanaPrincipal = new View(this);
        }
        return ventanaPrincipal;
    }

    public Tablero getTablero() {
        if(tablero == null){
            tablero = new Tablero();
        }
        return tablero;
    }

    public Bot getBot() {
        if(bot == null){
            bot = new Bot();
        }
        return bot;
    }

    public void cargarnivel(){
        int[][] matrizJuego = getTablero().getTableroIni();
        Graphics g = getVentanaPrincipal().getCanvas1().getGraphics();
        Rectangle2D[][] casillas = getVentanaPrincipal().getCanvas1().getCasilla();
        Color[][] colores = getVentanaPrincipal().getCanvas1().getColor();
        for(int i = 0; i<matrizJuego.length; i++){
            for(int j = 0; j<matrizJuego[0].length; j++){
                Color colornuevo = traerColor(matrizJuego[i][j]);
                colores[i][j] = colornuevo;
                int posx = (int) casillas[i][j].getX();
                int posy = (int) casillas[i][j].getY();
                int width = (int) casillas[i][j].getWidth();
                int height = (int) casillas[i][j].getHeight();
                g.setColor(colornuevo);
                g.fillRect(posx,posy,width,height);
            }
        }
        getVentanaPrincipal().getCanvas1().setColor(colores);
        dibujarBot((int) casillas[0][0].getCenterX(), (int) casillas[0][0].getCenterY());
        getVentanaPrincipal().getNewgame().setEnabled(false);
    }

    public void detenernivel(){
        getBot().setPosisionX(120);
        getBot().setPosisionY(120);
        getVentanaPrincipal().getCanvas1().setRobot(getBot());
        getVentanaPrincipal().repaint();

    }
    public void dibujarBot(int x, int y){
        getBot().setPosisionX(x);
        getBot().setPosisionY(y);
        Graphics g = getVentanaPrincipal().getCanvas1().getGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(getBot().getPosisionX(),getBot().getPosisionY(),50,50);
    }

    public Color traerColor(int num){
        Color seleccion=Color.WHITE;
        switch (num){
            case 1:
                seleccion = Color.WHITE;
                break;
            case 0:
                seleccion = Color.BLACK;
                break;
            case 3:
                seleccion = Color.BLUE;
                break;
        }
        return seleccion;
    }

    public void iniciar() {
        getVentanaPrincipal().setVisible(true);
    }
}
