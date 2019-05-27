package es.upm.fis2019.GUI;

import es.upm.fis2019.ControladorGestorUsuarios;
import es.upm.fis2019.ControladorUsuario;
import es.upm.fis2019.Login;

public class ManagerGUI {
    private LoginGUI login;



    private PublicacionesUsuarioGUI publicacionesUsuario;

    public ManagerGUI() {
        this.login = new LoginGUI(this);
        this.publicacionesUsuario = new PublicacionesUsuarioGUI();
    }

    public void run() {
        this.login.display();
    }

    public PublicacionesUsuarioGUI getPublicacionesUsuario() {
        return publicacionesUsuario;
    }
}

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