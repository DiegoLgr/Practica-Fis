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

public class LoginView extends JFrame implements ActionListener{

    private Container container = getContentPane();
    private JLabel titleLabel=new JLabel("LOGIN");
    private JLabel userLabel=new JLabel("USER");
    private JLabel passwordLabel=new JLabel("PASSWORD");
    private JTextField userTextField=new JTextField();
    private JPasswordField passwordField=new JPasswordField();
    private JButton loginButton=new JButton("LOGIN");
    private JButton cancelButton=new JButton("CANCEL");
    private JCheckBox showPassword=new JCheckBox("Show password");
    private String title = "Login";
    private ControladorUsuario controladorUsuario;
    private PublicacionesUsuarioView publicacionesUsuarioView;

    public LoginView(ControladorUsuario controladorUsuario, PublicacionesUsuarioView publicacionesUsuarioView){
        this.controladorUsuario=controladorUsuario;
        this.publicacionesUsuarioView=publicacionesUsuarioView;
        setLayoutManager();
        setLocationAndSize();
        addComponentToContainer();
        addActionEvent();

    }

    public String getTitle(){
        return this.title;
    }

    private void setLayoutManager(){
        container.setLayout(null);
    }
    private void setLocationAndSize(){
        titleLabel.setBounds(150,80,100,30);
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        cancelButton.setBounds(200,300,100,30);
    }
    private void addComponentToContainer(){
        container.add(titleLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(cancelButton);
    }

    private void addActionEvent()
    {
        //adding Action listener to components
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == loginButton) {
            String userText;
//            char[] pwdText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
//            pwdText = passwordField.getPassword();
//            String pwd = "";
//            for(char a:pwdText){
//                pwd += a;
//            }
            if (userText.equalsIgnoreCase("a") && pwdText.equalsIgnoreCase("a")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                this.publicacionesUsuarioView.displayPublicacionesPropias();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        if (e.getSource() == cancelButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char)0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }
}

//public class LoginView {
//    JPanel panel;
//    JFrame frame;
//    IAutentica usuario;
//    PublicacionesUsuarioView vistaPublicaciones;
//
//    LoginView(IAutentica usuario, PublicacionesUsuarioView vistaPublicaciones, JPanel panel, JFrame frame){
//        this.panel = panel;
//        this.frame = frame;
//        this.usuario = usuario;
//        this.vistaPublicaciones = vistaPublicaciones;
//    }
//    public void displayLogin() {
//        panel.setLayout(null);
//
//        JLabel userLabel = new JLabel("User");
//        userLabel.setBounds(10, 10, 80, 25);
//        this.panel.add(userLabel);
//
//        JTextField userText = new JTextField(20);
//        userText.setBounds(100, 10, 160, 25);
//        this.panel.add(userText);
//
//        JLabel passwordLabel = new JLabel("Password");
//        passwordLabel.setBounds(10, 40, 80, 25);
//        this.panel.add(passwordLabel);
//
//        JPasswordField passwordText = new JPasswordField(20);
//        passwordText.setBounds(100, 40, 160, 25);
//        this.panel.add(passwordText);
//        JButton loginButton = new JButton("login");
//        loginButton.setBounds(10, 80, 80, 25);
//        loginButton.addActionListener(new ActionLogin(usuario, vistaPublicaciones));
//        this.panel.add(loginButton);
//    }
//
//    private class ActionLogin implements ActionListener{
//        JFrame frame;
//        IAutentica usuario;
//        PublicacionesUsuarioView vistaPublicaciones;
//        ActionLogin(IAutentica usuario, PublicacionesUsuarioView vistaPuublicaciones){
//            this.usuario = usuario;
//            this.vistaPublicaciones = vistaPuublicaciones;
//        }
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if(this.usuario.verificar("yo", "123")){
//                this.vistaPublicaciones.displayPublicacionesPropias();
//            }else{
//                JDialog d = new JDialog(frame, "Contraseña o nombre de usuario incoreecto", true);
//                d.setLocationRelativeTo(frame);
//                d.setVisible(true);
//
//            }
//        }
//    }
//}

