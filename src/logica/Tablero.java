package logica;

public class Tablero {

    private int posicionXIni = 0;
    private int posicionYIni = 0;
    private int celdasInactivas = 2;
    private int centro;
    private Bot bot;
    private int posicionIni = bot.ORIENTE;
    public static final int CELDA_ACTIVA = 1;
    public static final int CELDA_INACTIVA = 0;
    public static final int CELDA_BLOQUEADA = 2;
    public static final int CELDA_NEUTRAL = 3;

    private int tableroIni[][] = {
            {CELDA_ACTIVA, CELDA_ACTIVA, CELDA_ACTIVA},
            {CELDA_INACTIVA, CELDA_INACTIVA, CELDA_ACTIVA},
            {CELDA_INACTIVA, CELDA_NEUTRAL, CELDA_ACTIVA},
    };
    public int tablero[][] = tableroIni;

    public Tablero(){

        bot = new Bot();
    }

    public Boolean verificacionCasilla(int x, int y){
        Boolean estado = false;
        try {
            switch (tableroIni[x][y]){
                case CELDA_ACTIVA:
                    estado = true;
                    break;
                case  CELDA_INACTIVA:
                    estado = false;
                    break;
                case  CELDA_NEUTRAL:
                    estado = true;
                    break;
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            return false;
        }


        return estado;
    }

    public Boolean verificacionFinciclo(int x, int y){
        Boolean estado = false;
        switch (tableroIni[x][y]){
            case CELDA_ACTIVA:
                estado = false;
                break;
            case  CELDA_INACTIVA:
                estado = false;
                break;
            case  CELDA_NEUTRAL:
                estado = true;
                break;
        }
        return estado;
    }

    public int[][] getTableroIni() {
        return tableroIni;
    }

    public void Resetiar(){
        tablero = tableroIni;
        bot.setPosisionX(posicionXIni);
        bot.setPosisionY(posicionYIni);
        bot.setDireccion(posicionIni);
    }

    public
    Bot getBot() {
        return bot;
    }

    public
    void setBot(Bot bot) {
        this.bot = bot;
    }

    public
    int getCeldasInactivas() {
        return celdasInactivas;
    }

    public
    void setCeldasInactivas(int celdasInactivas) {
        this.celdasInactivas = celdasInactivas;
    }

    public int getCentro() {
        return centro;
    }

    public void setCentro(int centro) {
        this.centro = centro;
    }
}
