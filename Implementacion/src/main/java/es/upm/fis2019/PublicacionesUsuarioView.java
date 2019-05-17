package es.upm.fis2019;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.*;

public class PublicacionesUsuarioView extends JPanel{
    private IPidePublicacion gestorPublicaciones;

    PublicacionesUsuarioView(IPidePublicacion gestorPublicaciones){
        this.gestorPublicaciones = gestorPublicaciones;
    }
    public void displayPublicacionesPropias() {
        removeAll();
        List<Publicacion> publicaciones = getPublicaciones();
        /*
        for (int i=0; i<publicaciones.length; i++){
            JLabel publicacion = new JLabel(publicaciones[i].getContenido());
            publicacion.setBounds(10, 10+25*i, 500, 25);
            this.panel.add(publicacion);
        }*/
        updateUI();
    }
    private List<Publicacion> getPublicaciones(){
        java.util.List<Publicacion> publicaciones;
        publicaciones = this.gestorPublicaciones.getPublicacionesPropias();
        return publicaciones;
    }
}

