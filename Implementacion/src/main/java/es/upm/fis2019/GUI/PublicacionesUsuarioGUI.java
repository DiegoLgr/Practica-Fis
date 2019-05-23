package es.upm.fis2019.GUI;

import es.upm.fis2019.IPidePublicacion;
import es.upm.fis2019.IPublicacion;

import javax.swing.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PublicacionesUsuarioGUI extends JFrame implements ActionListener {

    //TODO COMMIT GRANDE, POSIBLEMENTE EL SABADO. BUSCAR PUBLICACIONES EN BASE DE DATOS LEER LISTA Y DEVOLVER 5 EN FUNCION DE LA PAGINA EN LA QUE NOS ENCONTREMOS(MAX 10)


    private IPidePublicacion gestorPublicaciones;
    private GridBagConstraints ctes = new GridBagConstraints();
    private JButton publicar = new JButton("PUBLICAR");


    public PublicacionesUsuarioGUI(IPidePublicacion gestorPublicaciones) {
        this.gestorPublicaciones = gestorPublicaciones;
        this.getContentPane().setLayout(new GridBagLayout());
        //this.getContentPane().add(publicationView);
        addButtons();
        addPublications();
        navegation();
        setView();
    }

    private void addButtons() {

        ctes.gridx = 0;
        ctes.gridy = 0;
        ctes.gridwidth = 2;
        ctes.gridheight = 1;
        ctes.weighty = 1.0;
        ctes.weightx = 1.0;
        this.getContentPane().add(publicar, ctes);

    }

    private void addPublications() {
        String text = "Lorem ipsum dolor sit amet consectetur adipiscing elit, volutpat fames quam aliquet ac cras, curae varius vestibulum proin eleifend tempor. ";
        for (int i = 0; i < 5; i++) {
            ctes.gridx = 0;
            ctes.gridy = i + 1;
            ctes.gridwidth = 6;
            ctes.gridheight = 1;
            ctes.weighty = 1.0;
            ctes.fill = GridBagConstraints.BOTH;
            this.getContentPane().add(new PublicationGUI(text), ctes);
            reset();
        }
    }

    private void navegation() {

        for (int i = 0; i < 2; i++) {
            ctes.gridx = 2 * i;
            ctes.gridy = 7;
            ctes.gridwidth = 1;
            ctes.gridheight = 1;
            this.getContentPane().add(new JButton(), ctes);
            reset();
        }
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
        setTitle(getTitle());
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
            WriteGUI writeGUI = new WriteGUI();
        }
    }
}

