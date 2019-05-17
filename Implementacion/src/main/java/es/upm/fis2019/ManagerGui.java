package es.upm.fis2019;

import javax.swing.*;

public class ManagerGui {
    private ControladorGestorUsuarios controladorGestorUsuarios;
    private ControladorUsuario controladorUsuario;

    public ManagerGui(ControladorGestorUsuarios controladorGestorUsuarios, ControladorUsuario controladorUsuario) {
        this.controladorGestorUsuarios = controladorGestorUsuarios;
        this.controladorUsuario = controladorUsuario;
    }

    public void run(){
        PublicacionesUsuarioView vistaPublicacionesPropias = new PublicacionesUsuarioView(this.controladorUsuario);
        LoginView framel=new LoginView(controladorUsuario, vistaPublicacionesPropias);
        framel.setTitle(framel.getTitle());
        framel.setVisible(true);
        framel.setBounds(10,10,370,600);
        framel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        framel.setResizable(false);


//        JFrame frame = new JFrame("Demo application");
//        frame.setSize(600, 250);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel();
//        frame.add(panel);
//
//        frame.setVisible(true);
//
//        PublicacionesUsuarioView vistaPublicacionesPropias = new PublicacionesUsuarioView(this.controladorUsuario, panel);
//        LoginView login = new LoginView(this.controladorUsuario, vistaPublicacionesPropias);

//        login.displayLogin();
    }
}

