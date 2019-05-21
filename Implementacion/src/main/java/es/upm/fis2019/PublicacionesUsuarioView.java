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

public class PublicacionesUsuarioView {
    IPidePublicacion gestorPublicaciones;
    JPanel panel;
    PublicacionesUsuarioView(IPidePublicacion gestorPublicaciones, JPanel panel){
        this.gestorPublicaciones = gestorPublicaciones;
        this.panel = panel;
    }
    public void displayPublicacionesPropias() {
        this.panel.removeAll();
        List<IPublicacion> publicaciones = getPublicaciones();
        /*
        for (int i=0; i<publicaciones.length; i++){
            JLabel publicacion = new JLabel(publicaciones[i].getContenido());
            publicacion.setBounds(10, 10+25*i, 500, 25);
            this.panel.add(publicacion);
        }*/
        panel.updateUI();
    }
    private List<Publicacion> getPublicaciones(){
        java.util.List<Publicacion> publicaciones;
        publicaciones = this.gestorPublicaciones.getPublicacionesPropias();
        return publicaciones;
    }
}

