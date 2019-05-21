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
    private GridBagConstraints ctes = new GridBagConstraints();


    public PublicacionesUsuarioView(IPidePublicacion gestorPublicaciones, PublicationView publicationView){
        this.gestorPublicaciones = gestorPublicaciones;
        this.publicationView = publicationView;
        this.getContentPane().setLayout(new GridBagLayout());
        //this.getContentPane().add(publicationView);
        addButtons();
        addPublications();
        setView();
    }

    private void addButtons(){

        for(int i=0;i<3;i++){
            JButton button = new JButton("text " + i);
            ctes.gridx=2*i;
            ctes.gridy=0;
            ctes.gridwidth=2;
            ctes.gridheight=1;
            this.getContentPane().add(button,ctes);
        }
    }

    private void addPublications(){
        for(int i=0; i<5; i++){
            ctes.gridx=0;
            ctes.gridy=i+1;
            ctes.gridwidth=6;
            ctes.gridheight=1;
            this.getContentPane().add(new PublicationView(), ctes);
        }
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
        setResizable(true);
    }

    private void reset(){
        ctes.fill = GridBagConstraints.NONE;
        ctes.weightx = 0.0;
        ctes.weighty = 0.0;
    }

    private List<IPublicacion> getPublicaciones(){
        java.util.List<IPublicacion> publicaciones;
        publicaciones = this.gestorPublicaciones.getPublicacionesPropias();
        return publicaciones;
    }
}

