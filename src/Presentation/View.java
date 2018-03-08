package Presentation;

import logica.Bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class View extends JFrame {

    //Atributos

    private JLabel text1;
    private JButton newgame;
    private JButton iniciar;
    private JButton detener;
    private JButton reiniciar;
    private JButton limpiar;
    private JButton avanzar;
    private JButton girar;
    private JButton alumbrar;
    private JList listacciones;
    private Dibujo canvas1;
    private DefaultListModel dlmA = new DefaultListModel();
    private controller controlVista;
    private int posX, posY;
    private final model Modelo;


    //Metodo Constructor
    public View(model Modelo){
        canvas1 = new Dibujo();
        this.Modelo = Modelo;
        initComponents();
        capturaEventos();
    }


    private void initComponents() {
        setSize(900,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text1 = new JLabel("Lista de Acciones");
        newgame = new JButton("Nuevo Juego");
        iniciar = new JButton("Iniciar");
        detener = new JButton("Detener");
        reiniciar = new JButton("Reiniciar");
        limpiar = new JButton("Limpiar");
        avanzar = new JButton("Avanzar");
        girar = new JButton("Girar");
        alumbrar = new JButton("Alumbrar");
        listacciones = new JList();

        add(canvas1);
        add(text1);
        add(newgame);
        add(iniciar);
        add(detener);
        add(reiniciar);
        add(limpiar);
        add(avanzar);
        add(girar);
        add(alumbrar);
        add(listacciones);

        text1.reshape(550,30,200,20);
        newgame.reshape(760,100,100,20);
        iniciar.reshape(760,150, 100, 20);
        detener.reshape(760,200, 100, 20);
        reiniciar.reshape(760,250, 100, 20);
        limpiar.reshape(760,300,100,20);
        avanzar.reshape(70,530, 100, 20);
        girar.reshape(200,530, 100, 20);
        alumbrar.reshape(330,530, 100, 20);
        listacciones.reshape(550,60,200,300);

        avanzar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avanzarMouseClicked(evt);
            }
        });

        girar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                girarMouseClicked(evt);
            }
        });

        alumbrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alumbrarMouseClicked(evt);
            }
        });

        limpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limpiarMouseClicked(evt);
            }
        });

    }

    public controller getControl() {
        if(controlVista == null){
            controlVista = new controller(this);
        }
        return controlVista;
    }

    private void capturaEventos() {
        iniciar.addActionListener(getControl());
        detener.addActionListener(getControl());
        reiniciar.addActionListener(getControl());
        newgame.addActionListener(getControl());
    }


    private void avanzarMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        try {
            dlmA.addElement("avanzar");
            listacciones.setModel(dlmA);

        } catch (Exception er) {

        }
    }

    private void girarMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        try {
            dlmA.addElement("girar");
            listacciones.setModel(dlmA);
        } catch (Exception er) {

        }
    }

    private void alumbrarMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        try {
            dlmA.addElement("alumbrar");
            listacciones.setModel(dlmA);
        } catch (Exception er) {

        }
    }

    private void limpiarMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        try {
            dlmA.removeAllElements();
            listacciones.setModel(dlmA);
        } catch (Exception er) {

        }
    }

    public DefaultListModel getDlmA() {
        return dlmA;
    }

    public JButton getIniciar() {
        return iniciar;
    }

    public JButton getDetener() {
        return detener;
    }

    public JButton getNewgame() {
        return newgame;
    }

    public JButton getLimpiar() {
        return limpiar;
    }

    public JButton getAvanzar() {
        return avanzar;
    }

    public JButton getGirar() {
        return girar;
    }

    public JButton getAlumbrar() {
        return alumbrar;
    }

    public JButton getReiniciar() {
        return reiniciar;
    }

    public Dibujo getCanvas1() {
        return canvas1;
    }

    public model getModelo() {
        return Modelo;
    }

}
