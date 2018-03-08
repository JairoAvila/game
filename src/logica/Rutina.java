package logica;

import java.util.ArrayList;
import java.util.Map;

public class Rutina{

    public final static int AVANZAR = 10;
    public final static int ACTIVAR = 12;
    public final static int GIRAR_HORARIO = 13;
    public final static int GIRAR_ANTIHORARIO = 14;

    private ArrayList<String> mapeo = new ArrayList<String>();

    private ArrayList<Integer> rutina;
    private int puntero;
    private Tablero tablero;

    public Rutina(){
        this.rutina = rutina;
        tablero = new Tablero();
        puntero = 0;
    }

    public void Correr(){
        try {
            switch (rutina.get(puntero)) {
                case AVANZAR:
                    //tablero.getBot().Activar();
                    System.out.println(tablero.getBot());
                    tablero.getBot().Avanzar();
                    break;
                case ACTIVAR:
                    System.out.println(tablero.getBot());
                    tablero.getBot().Activar();
                    if (tablero.getCeldasInactivas() == 0) {
                        System.out.println("termino juego");
                        Borrar();
                    }
                    ;
                    break;
                case GIRAR_ANTIHORARIO:
                    System.out.println(tablero.getBot());
                    tablero.getBot().GirarAntihorario();
                    break;
                case GIRAR_HORARIO:
                    System.out.println(tablero.getBot());
                    tablero.getBot().GirarHorario();
                    break;
            }
            puntero++;
        }catch (IndexOutOfBoundsException ex){
            System.err.println("No hay más pasos en la pila");
            System.exit(0);
        }
    }

    public void Reiniciar(){
        puntero = 0;
        tablero.Resetiar();
        System.out.println("Se reinicio el juego");
    }

    public void Borrar(){
        puntero = 0;
        rutina.clear();
        tablero.Resetiar();
        System.out.println("Se borra la partida");
    }

    public
    Tablero getTablero() {
        return tablero;
    }

    public ArrayList<String> getMapeo() {
        return mapeo;
    }

    public void setMapeo(ArrayList<String> mapeo) {
        this.mapeo = mapeo;
    }
}
