package es.upm.fis2019;

import es.upm.fis2019.GUI.ManagerGUI;

public class App {
    static ControladorGestorUsuarios controladorGestorUsuarios;
    static ControladorComentario controladorComentario;
    static ControladorPublicaciones controladorPublicaciones;

    public static void main(String[] args) {
        App.controladorGestorUsuarios = new ControladorGestorUsuarios();
        App.controladorComentario = new ControladorComentario();
        App.controladorPublicaciones = new ControladorPublicaciones();

        ManagerGUI gui = new ManagerGUI(controladorGestorUsuarios);
        gui.run();
    }
    public static ControladorPublicaciones getControladorPublicaciones(){
        return App.controladorPublicaciones;
    }
}

