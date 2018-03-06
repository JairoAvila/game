package Presentation;

import logica.Rutina;

import java.util.ArrayList;

public class model {

    private Rutina rutina;

    private ArrayList<Integer> pasos = null;

    public model() {
        rutina = new Rutina(pasos);
    }

    public String getData() {

        String data = "FABIAN";

        return data;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public ArrayList<Integer> getPasos() {
        return pasos;
    }

    public
    void setPasos(ArrayList<Integer> pasos) {
        this.pasos = pasos;
    }
}
