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

public class LoginGUI extends JFrame implements ActionListener {
    private String applyTextColor = "color: #0C56CE;";
    private String applyTextSize = "font-size: 8px;";
    private String applyButtonTextColor = "color: #ffffff;";
    private String applyButtonTextSize = "font-size: 12px;";
    private Container container = getContentPane();
    private JLabel titleLabel = new JLabel("<html><h1 style=\""+applyTextColor+"\">LOGIN</h1></html>");
    private JLabel userLabel = new JLabel("<html><span style=\""+applyTextColor+applyTextSize+"\">Username</spam></html>");
    private JLabel passwordLabel = new JLabel("<html><span style=\""+applyTextColor+applyTextSize+"\">Password</spam></html>");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("<html><span style=\""+applyButtonTextColor+applyButtonTextSize+"\">LOGIN</spam></html>");
    private JButton cancelButton = new JButton("CANCEL");
    private JCheckBox showPassword = new JCheckBox("<html><span style=\""+applyTextColor+applyTextSize+"\">show Password</spam></html>");
    private String title = "Login";
    private int fieldsStartY = 110;
    private int fieldsStartx = 50;

    private ManagerGUI gui;

    public LoginGUI(ManagerGUI gui) {
        setLayoutManager();
        setLocationAndSize();
        addComponentToContainer();
        addActionEvent();
        this.gui = gui;
    }

    public String getTitle() {
        return this.title;
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }

    // ############# Generando los componentes gráficos #############

    private void setLocationAndSize() {
        titleLabel.setBounds(150, 40, 100, 30);
        userLabel.setBounds(fieldsStartx, fieldsStartY, 100, 15);
        userTextField.setBounds(fieldsStartx, fieldsStartY+14, 270, 30);
        passwordLabel.setBounds(fieldsStartx, fieldsStartY+46, 100, 15);
        passwordField.setBounds(fieldsStartx, fieldsStartY+60, 270, 30);
        showPassword.setBounds(fieldsStartx + 170, fieldsStartY+92, 150, 15);
        showPassword.setBackground(new Color(255,255,255));
        loginButton.setBounds(110, 300, 150, 50);
        loginButton.setBackground(new Color(12,86,206));
        cancelButton.setBounds(200, 300, 100, 30);
    }

    private void addComponentToContainer() {
        container.add(titleLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        //container.add(cancelButton);
    }

    private void addActionEvent() {
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

//    ############# Logica de la vista #############

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            if (this.userLogedSuccesfully()) {
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                gui.getPublicacionesUsuario().display();
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
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }

    private boolean userLogedSuccesfully() {
        String userText;
        String pwdText;
        userText = userTextField.getText();
        pwdText = passwordField.getText();

        IUsuario iUsuario;
        IBusca iBusca = new ControladorGestorUsuarios();
        iUsuario = iBusca.buscarUsuario(userText);
        if (!userText.isEmpty() && !pwdText.isEmpty()){
            System.out.println(userText);
            String realUser = iUsuario.getAlias();
            String realUserPsw = iUsuario.getPassword();

            if (userText.equalsIgnoreCase(realUser) && pwdText.equalsIgnoreCase(realUserPsw)) {
                Sesion.getInstance().setUsuario((Usuario) iUsuario);
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }

    }

    // ############# Funciones públicas #############

    public void display() {
        setTitle(getTitle());
        setVisible(true);
        setBounds(685, 250, 370, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setResizable(false);
    }
}
