package Presentation;

import logica.Rutina;
import logica.Tablero;
import logica.Bot;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Map;

public class model implements Runnable {
    private View ventanaPrincipal;
    private Tablero tablero;
    private Bot bot;
    private Rutina rutina;
    private Thread hiloDibujo;
    private ArrayList<String> pasos;

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

    public Rutina getRutina() {
        if(rutina == null){
            rutina = new Rutina();
        }
        return rutina;
    }

    public void ejecutarcomandos(){
        pasos = conversor(getVentanaPrincipal().getDlmA());
        if(pasos.size() > 0){
           getVentanaPrincipal().getIniciar().setEnabled(false);
           hiloDibujo = new Thread(this,"HILO1");
           hiloDibujo.start();
        }
        else
        {
            JOptionPane.showMessageDialog(getVentanaPrincipal(),"La lista de pasos esta vacia, intente de nuevo");
        }
    }

    public ArrayList<String> conversor(DefaultListModel pasos){
        ArrayList<String> arreglo = new ArrayList<String>();
        for(int i = 0; i<pasos.getSize(); i++){
            arreglo.add(i,pasos.elementAt(i).toString());
        }
        return arreglo;
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
        getTablero().setCentro(((int) casillas[0][0].getCenterX() + (int) casillas[0][0].getCenterY())/2);
        getBot().setCoordenada("0,0");
        dibujarBot((int) casillas[0][0].getCenterX(), (int) casillas[0][0].getCenterY());
        getVentanaPrincipal().getNewgame().setEnabled(false);
        getVentanaPrincipal().getIniciar().setEnabled(true);
        getVentanaPrincipal().getDetener().setEnabled(true);
        getVentanaPrincipal().getLimpiar().setEnabled(true);
    }

    public void detenernivel(){
        Rectangle2D[][] casillas = getVentanaPrincipal().getCanvas1().getCasilla();
        getTablero().setCentro(((int) casillas[0][0].getCenterX() + (int) casillas[0][0].getCenterY())/2);
        getBot().setCoordenada("0,0");
        actualizarBot((int) casillas[0][0].getCenterX(), (int) casillas[0][0].getCenterY());
        getRutina().getMapeo().clear();
        getVentanaPrincipal().getIniciar().setEnabled(true);
    }
    public void dibujarBot(int x, int y){
        getBot().setPosisionX(x);
        getBot().setPosisionY(y);
        getBot().setDireccion(23);
        Graphics2D g = (Graphics2D) getVentanaPrincipal().getCanvas1().getGraphics();
        ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/car1.png"));
        g.rotate(getBot().angulos(getBot().getDireccion()), 100, 100);
        g.drawImage(Img.getImage(), getBot().getPosisionX(), getBot().getPosisionY() , null);
    }

    public void actualizarBot(int x, int y){
        getBot().setPosisionX(x);
        getBot().setPosisionY(y);
        getBot().setDireccion(23);
        getVentanaPrincipal().getCanvas1().setRobot(getBot());
        getVentanaPrincipal().repaint();

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

    public void parametro(String entrada){
        switch (entrada){
            case "avanzar":
                avanzar();
                break;
            case "girar":
                System.out.println(2);
                break;
            case "alumbrar":
                System.out.println(3);
                break;
        }
    }

    public void iniciar() {
        getVentanaPrincipal().setVisible(true);
        getVentanaPrincipal().getIniciar().setEnabled(false);
        getVentanaPrincipal().getDetener().setEnabled(false);
        getVentanaPrincipal().getLimpiar().setEnabled(false);
    }

    public void avanzar(){
        for(int i = 0; i<4; i++){
            String casillaAnalisis = analisisCasilla(i);
            String[] coordenada = casillaAnalisis.split(",");
            int x = Integer.parseInt(coordenada[0]);
            int y = Integer.parseInt(coordenada[1]);
            if(x >= 0 && y >= 0){
                if (!getRutina().getMapeo().contains(casillaAnalisis)) {
                    Boolean estadocasilla = getTablero().verificacionCasilla(x, y);
                    if(estadocasilla){
                        getRutina().getMapeo().add(getBot().getCoordenada());
                        getBot().setCoordenada(casillaAnalisis);
                        Rectangle2D[][] casillas = getVentanaPrincipal().getCanvas1().getCasilla();
                        actualizarBot((int) casillas[x][y].getCenterX(), (int) casillas[x][y].getCenterY());
                        break;
                    }
                }
            }
        }
    }

    public String analisisCasilla(int op){
        String[] posicion = getBot().getCoordenada().split(",");
        int x = Integer.parseInt(posicion[0]);
        int y = Integer.parseInt(posicion[1]);
        switch (op){
            case 0:
                x = x - 1;
                break;
            case 1:
                y = y + 1;
                break;
            case 2:
                x = x + 1;
                break;
            case 3:
                y = y - 1;
                break;
        }

        return x+","+y;
    }


    @Override
    public void run() {
        for(int i = 0; i < pasos.size(); i++){
            parametro(pasos.get(i));
        }
    }
}
