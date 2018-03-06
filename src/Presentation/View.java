package Presentation;

import javax.swing.*;

public class View extends JFrame {

    //Atributos

    private JLabel rutina;
    private JButton iniciar;
    private JButton detener;
    private JButton limpiar;
    private JButton avanzar;
    private JButton girar;
    private JButton girarA;
    private JButton alumbrar;
    private JButton traslado;
    private JList listacciones;
    private Dibujo canvas1;
    private DefaultListModel dlmA = new DefaultListModel();
    private controller controlVista;
    private int posX, posY;


    //Metodo Constructor
    public View(){
        canvas1 = new Dibujo();
        initComponents();
        capturaEventos();
    }


    private void initComponents() {
        setSize(900,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rutina = new JLabel("Lista de Acciones");
        iniciar = new JButton("Iniciar");
        detener = new JButton("Detener");
        limpiar = new JButton("Limpiar");
        avanzar = new JButton("Avanzar");
        girar = new JButton("Girar Horario");
        girarA = new JButton("Girar Antihorario");
        alumbrar = new JButton("Alumbrar");
        traslado = new JButton("Traslado");
        listacciones = new JList();

        add(canvas1);
        add(rutina);
        add(iniciar);
        add(detener);
        add(limpiar);
        add(avanzar);
        add(girar);
        add(girarA);
        add(alumbrar);
        add(traslado);
        add(listacciones);

        rutina.reshape(550,30,200,20);
        iniciar.reshape(760,150, 100, 20);
        detener.reshape(760,200, 100, 20);
        limpiar.reshape(760,250,100,20);
        avanzar.reshape(70,530, 100, 20);
        girar.reshape(200,530, 100, 20);
        alumbrar.reshape(330,530, 100, 20);
        girarA.reshape(100, 560, 150,20);
        traslado.reshape(300, 560, 100,20);
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

        girarA.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){
                girarAMouseClicked(evt);
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

        traslado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trasladoMouseClicked(evt);
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
        avanzar.addActionListener(getControl());
        girar.addActionListener(getControl());
        girarA.addActionListener(getControl());
        limpiar.addActionListener(getControl());
        alumbrar.addActionListener(getControl());
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

    private void girarAMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        try {
            dlmA.addElement("girarA");
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

    private void trasladoMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        try {
            canvas1.setXcircle(2);
            canvas1.setYcircle(2);
            repaint();

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

    public JButton getAvanzar() {
        return avanzar;
    }

    public JButton getGirar() {
        return girar;
    }

    public JButton getGirarA() {
        return girarA;
    }

    public JLabel getRutina() {
        return rutina;
    }
}
