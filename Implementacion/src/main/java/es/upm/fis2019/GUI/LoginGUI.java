package es.upm.fis2019.GUI;
import es.upm.fis2019.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI extends JFrame implements ActionListener{
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

    public LoginGUI(){
        setLayoutManager();
        setLocationAndSize();
        addComponentToContainer();
        addActionEvent();
        //setView();
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
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    public void display(){
        setTitle(getTitle());
        setVisible(true);
        setBounds(10,10,370,500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();

            IUsuario iUsuario;
            IBusca iBusca= new ControladorGestorUsuarios();
            iUsuario=iBusca.buscarUsuario(userText);

            if (userText.equalsIgnoreCase(iUsuario.getAlias()) && pwdText.equalsIgnoreCase(iUsuario.getPassword())) {
                Sesion.getInstance().setUsuario((Usuario) iUsuario);
                JOptionPane.showMessageDialog(this, "Login Successful");
                PublicacionesUsuarioGUI publicacionesUsuarioGUI = new PublicacionesUsuarioGUI();
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
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
