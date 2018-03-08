package Presentation;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class controller implements MouseListener,ActionListener, ComponentListener, ChangeListener {

    private final View ventanaPrincipal;
    private model modelo;

    public controller(View ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        modelo = ventanaPrincipal.getModelo();
    }

    /*public String getMessage() {
        try {
            model modelo = new model();
            return modelo.getData();
        } catch (Exception er) {
            return "There was an error.";
        }
    }*/

    public void actionPerformed(ActionEvent e) {
        int respuesta;
        if(e.getSource() instanceof JButton){
            JButton boton = (JButton) e.getSource();

            if (boton == ventanaPrincipal.getIniciar()) {
                getModelo().ejecutarcomandos();
            } else if (boton == ventanaPrincipal.getDetener()) {
                getModelo().detenernivel();
            } else if (boton == ventanaPrincipal.getNewgame()){
                getModelo().cargarnivel();
            }
        }
    }

    public void componentResized(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentShown(ComponentEvent e) {

    }

    public void componentHidden(ComponentEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void stateChanged(ChangeEvent e) {

    }

    public model getModelo() {
        return modelo;
    }
}
