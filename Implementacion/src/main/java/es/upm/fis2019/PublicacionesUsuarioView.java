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
import java.util.*;
import java.util.List;

public class PublicacionesUsuarioView extends JFrame {
    private IPidePublicacion gestorPublicaciones;
    private PublicationView publicationView;

    public PublicacionesUsuarioView(IPidePublicacion gestorPublicaciones, PublicationView publicationView){
        this.gestorPublicaciones = gestorPublicaciones;
        this.publicationView = publicationView;
        setView();
    }

    public void displayPublicacionesPropias() {
        this.publicationView.removeAll();
        List<IPublicacion> publicaciones = getPublicaciones();
        /*
        for (int i=0; i<publicaciones.length; i++){
            JLabel publicacion = new JLabel(publicaciones[i].getContenido());
            publicacion.setBounds(10, 10+25*i, 500, 25);
            this.panel.add(publicacion);
        }*/
//        publicationView.updateUI();
    }

    private void setView(){
        setTitle(getTitle());
        setVisible(true);
        setBounds(10,10,700,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private List<IPublicacion> getPublicaciones(){
        java.util.List<IPublicacion> publicaciones;
        publicaciones = this.gestorPublicaciones.getPublicacionesPropias();
        return publicaciones;
    }
}

