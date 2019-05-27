package es.upm.fis2019.GUI;

import es.upm.fis2019.IPidePublicacion;
import es.upm.fis2019.IPublicacion;
import es.upm.fis2019.Publicacion;

import javax.swing.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PublicacionesUsuarioGUI extends JFrame implements ActionListener {


    private IPidePublicacion gestorPublicaciones;
    private GridBagConstraints ctes = new GridBagConstraints();
    private JButton publicar = new JButton("PUBLICAR");
    private JButton derecha = new JButton("=>");
    private JButton izquierda = new JButton("<=");


    public PublicacionesUsuarioGUI(IPidePublicacion gestorPublicaciones) {
        this.gestorPublicaciones = gestorPublicaciones;
        this.getContentPane().setLayout(new GridBagLayout());
        addButtons();
        addPublications();
        navegation();
        setView();
    }

    private void addButtons() {

        ctes.gridx = 1;
        ctes.gridy = 0;
        ctes.gridwidth = 1;
        ctes.gridheight = 1;
        ctes.weightx = 1.0;
        this.getContentPane().add(publicar, ctes);
        reset();

    }

    private void addPublications() {
        //TODO cambiar el new y que ya esten instanciadas las publicaciones GUI al llamar al metodo y que lo que haga sea  coger publicacion 1 y situarla en el 0,1 , la dos y en el 0,2...
        List<IPublicacion> listPublicaciones = gestorPublicaciones.getPublicacionesPropias();
//        String text = "Lorem ipsum dolor sit amet consectetur adipiscing elit, volutpat fames quam aliquet ac cras, curae varius vestibulum proin eleifend tempor. ";
        for (int i = 0; i < listPublicaciones.size(); i++) {
            ctes.gridx = 0;
            ctes.gridy = i + 1;
            ctes.gridwidth = 3;
            ctes.gridheight = 1;
            ctes.weighty = 1.0;
            ctes.fill = GridBagConstraints.BOTH;
            this.getContentPane().add(new PublicationGUI(listPublicaciones.get(i), this), ctes);
            reset();
        }
    }

    private void navegation() {
        ctes.gridx = 0;
        ctes.gridy = 7;
        ctes.gridwidth = 1;
        ctes.gridheight = 1;
        this.getContentPane().add(izquierda, ctes);
        reset();

        ctes.gridx = 2;
        ctes.gridy = 7;
        ctes.gridwidth = 1;
        ctes.gridheight = 1;
        this.getContentPane().add(derecha, ctes);
        reset();
        addActionEvent();
    }

    public void displayPublicacionesPropias() {
        List<IPublicacion> publicaciones = getPublicaciones();
        /*
        for (int i=0; i<publicaciones.length; i++){
            JLabel publicacion = new JLabel(publicaciones[i].getContenido());
            publicacion.setBounds(10, 10+25*i, 500, 25);
            this.panel.add(publicacion);
        }*/
//        publicationView.updateUI();
    }

    private void setView() {
        setTitle("Publicaciones");
        setVisible(true);
        setBounds(10, 10, 700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
    }

    private void reset() {
        ctes.fill = GridBagConstraints.NONE;
        ctes.weightx = 0.0;
        ctes.weighty = 0.0;
    }

    public void updateGUI() {
        //TODO solucionar que se inserten 2 veces, TODO arriba deberia solucionarlo
        this.getContentPane().removeAll();
        addButtons();
//        addPublications();
        navegation();
        setView();
    }

    private List<IPublicacion> getPublicaciones() {
        java.util.List<IPublicacion> publicaciones;
        publicaciones = this.gestorPublicaciones.getPublicacionesPropias();
        return publicaciones;
    }

    private void addActionEvent() {
        publicar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == publicar) {
            WriteGUI writeGUI = new WriteGUI("Publicacion");
            updateGUI();
        }
    }
}

