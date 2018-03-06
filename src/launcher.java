import Presentation.model;

public class launcher {

    private model myApp;

    public launcher() {
        myApp = new model();
        myApp.iniciar();
    }

    public static void main(String args[]) {
        new launcher();
    }
}
