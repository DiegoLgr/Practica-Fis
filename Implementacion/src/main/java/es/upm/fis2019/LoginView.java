package es.upm.fis2019;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView {
    JPanel panel;
    JFrame frame;
    IAutentica usuario;
    PublicacionesUsuarioView vistaPublicaciones;

    LoginView(IAutentica usuario, PublicacionesUsuarioView vistaPublicaciones, JPanel panel, JFrame frame){
        this.panel = panel;
        this.frame = frame;
        this.usuario = usuario;
        this.vistaPublicaciones = vistaPublicaciones;
    }
    public void displayLogin() {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        this.panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        this.panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        this.panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        this.panel.add(passwordText);
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new ActionLogin(usuario, vistaPublicaciones));
        this.panel.add(loginButton);
    }

    private class ActionLogin implements ActionListener{
        JFrame frame;
        IAutentica usuario;
        PublicacionesUsuarioView vistaPublicaciones;
        ActionLogin(IAutentica usuario, PublicacionesUsuarioView vistaPuublicaciones){
            this.usuario = usuario;
            this.vistaPublicaciones = vistaPuublicaciones;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(this.usuario.verificar("yo", "123")){
                this.vistaPublicaciones.displayPublicacionesPropias();
            }else{
                JDialog d = new JDialog(frame, "Contraseña o nombre de usuario incoreecto", true);
                d.setLocationRelativeTo(frame);
                d.setVisible(true);

            }
        }
    }
}

