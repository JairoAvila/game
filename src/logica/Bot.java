package logica;

public class Bot   {

    public static final int NORTE = 21;
    public static final int ORIENTE = 22;
    public static final int SUR = 23;
    public static final int OCCIDENTE = 24;

    private int posisionX;
    private int posisionY;
    private int direccion;

    private Tablero tablero;

    public Bot (int direccion, int posisionX, int posisionY, Tablero tablero){
        this.direccion = direccion;
        this.posisionX = posisionX;
        this.posisionY = posisionY;
        this.tablero = tablero;

        this.direccion = ORIENTE;
    }

    public void GirarHorario (){
        switch (direccion){
            case NORTE:
                direccion = ORIENTE;
                break;
            case ORIENTE:
                direccion = SUR;
                break;
            case SUR:
                direccion = OCCIDENTE;
                break;
            case OCCIDENTE:
                direccion = NORTE;
                break;
        }
        System.out.println("Gira sentido Horario");
    }

    public void GirarAntihorario (){
        //TODO
        switch (direccion){
            case NORTE:
                direccion = OCCIDENTE;
                break;
            case OCCIDENTE:
                direccion = SUR;
                break;
            case SUR:
                direccion = ORIENTE;
                break;
            case ORIENTE:
                direccion = NORTE;
                break;
        }
        System.out.println("Gira sentido Antihorario");
    }

    public void Avanzar (){
        switch (direccion){
            case NORTE:
                posisionY = (Mirar(posisionX, posisionY-1) ? posisionY - 1: posisionX);
                System.out.println("Avanza hacia el norte");
                break;
            case ORIENTE:
                posisionX = (Mirar(posisionX+1, posisionY) ? posisionX + 1 : posisionY);
                System.out.println("Avanza hacia el oriente");
                break;
            case SUR:
                posisionY = (Mirar(posisionX, posisionY+1) ? posisionY + 1 : posisionY);
                System.out.println("Avanza hacia el sur");
                break;
            case OCCIDENTE:
                posisionX = (Mirar(posisionX-1, posisionY) ? posisionX - 1 : posisionX);
                System.out.println("Avanza hacia el occidente");
                break;
        }
    }

    private boolean Mirar(int posisionX, int posisionY){
        try{
            if(tablero.tablero[posisionY][posisionX] == tablero.CELDA_BLOQUEADA){
                return false;
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            System.err.println("Salio de las cordenadas");
            return false;
        }

        return true;
    }

    public void Activar(){
        if(tablero.tablero[posisionY][posisionX] == tablero.CELDA_INACTIVA){
            tablero.tablero[posisionY][posisionX] = tablero.CELDA_ACTIVA;
            tablero.setCeldasInactivas(tablero.getCeldasInactivas()-1);
        }
        System.out.println("Activo celda");
    }

    @Override
    public String toString() {
        String direccion = null;

        switch (this.direccion){
            case NORTE:
                direccion = "Norte";
                break;
            case ORIENTE:
                direccion = "Oriente";
                break;
            case SUR:
                direccion = "Sur";
                break;
            case OCCIDENTE:
                direccion = "Occidente";
                break;
        }

        return "Bot esta viendo al " + direccion + " en la posición (" + posisionX + "," + posisionY + ")";

    }

    public int getDireccion () {
        return direccion;
    }

    public void setDireccion (int direccion) {
        this.direccion = direccion;
    }

    public int getPosisionX() {
        return posisionX;
    }

    public void setPosisionX(int posisionX) {
        this.posisionX = posisionX;
    }

    public int getPosisionY() {
        return posisionY;
    }

    public void setPosisionY(int getPosisionY) {
        this.posisionY = getPosisionY;
    }
}
