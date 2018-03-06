package logica;

public class Tablero {

    public static final int CELDA_ACTIVA = 1;
    public static final int CELDA_INACTIVA = 0;
    public static final int CELDA_BLOQUEADA = 2;
    public static final int CELDA_NEUTRAL = 3;

    private Bot bot;

    private int posicionXIni = 0;
    private int posicionYIni = 0;
    private int celdasInactivas = 2;
    private int posicionIni = bot.ORIENTE;

    private int tableroIni[][] = {
            {CELDA_NEUTRAL, CELDA_NEUTRAL, CELDA_NEUTRAL},
            {CELDA_INACTIVA, CELDA_NEUTRAL, CELDA_NEUTRAL},
            {CELDA_NEUTRAL, CELDA_NEUTRAL, CELDA_INACTIVA},
    };

    public int tablero[][] = tableroIni;

    public Tablero(){
        bot = new Bot(posicionIni, posicionXIni,posicionYIni, this);
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
}
