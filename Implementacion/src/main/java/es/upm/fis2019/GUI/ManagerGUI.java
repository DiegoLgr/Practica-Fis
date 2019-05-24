package es.upm.fis2019.GUI;

import es.upm.fis2019.ControladorGestorUsuarios;
import es.upm.fis2019.ControladorUsuario;

public class ManagerGUI {
    private ControladorGestorUsuarios controladorGestorUsuarios;

    public ManagerGUI(ControladorGestorUsuarios controladorGestorUsuarios) {
        this.controladorGestorUsuarios = controladorGestorUsuarios;
    }

    public void run() {
        //TODO el constructor de PublicacionesUsuarioGUI NO va aqui, se crea en login una vez hemos establecido sesion
        LoginGUI login = new LoginGUI();


//        JFrame frame = new JFrame("Demo application");
//        frame.setSize(600, 250);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel();
//        frame.add(panel);
//
//        frame.setVisible(true);
//
//        PublicacionesUsuarioGUI vistaPublicacionesPropias = new PublicacionesUsuarioGUI(this.controladorUsuario, panel);
//        LoginGUI login = new LoginGUI(this.controladorUsuario, vistaPublicacionesPropias);

//        login.displayLogin();
    }
}

