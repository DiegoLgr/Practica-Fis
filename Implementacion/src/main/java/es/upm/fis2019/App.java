package es.upm.fis2019;

import es.upm.fis2019.GUI.ManagerGUI;

public class App {
    static ControladorGestorUsuarios controladorGestorUsuarios;
    static ControladorComentario controladorComentario;
    static ControladorPublicaciones controladorPublicaciones;
    static ControladorUsuario contoladorUsuario;

    static Sesion sesion;

    public static void main(String[] args) {
        new Sesion();

        App.controladorGestorUsuarios = new ControladorGestorUsuarios();
        App.controladorComentario = new ControladorComentario();
        App.controladorPublicaciones = new ControladorPublicaciones();
        App.contoladorUsuario = new ControladorUsuario();


        ManagerGUI gui = new ManagerGUI(controladorGestorUsuarios);
        gui.run();
    }

    public static ControladorPublicaciones getControladorPublicaciones() {
        return App.controladorPublicaciones;
    }

    public static ControladorComentario getControladorComentario() {
        return controladorComentario;
    }

    public static ControladorGestorUsuarios getControladorGestorUsuarios() {
        return controladorGestorUsuarios;
    }

    public static ControladorUsuario getContoladorUsuario() {
        return contoladorUsuario;
    }
}
