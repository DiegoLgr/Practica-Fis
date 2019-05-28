package es.upm.fis2019.GUI;

import es.upm.fis2019.App;
import es.upm.fis2019.IPidePublicacion;
import es.upm.fis2019.IPublicacion;
import es.upm.fis2019.Publicacion;

import javax.swing.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PublicacionesUsuarioGUI extends JFrame implements ActionListener {


    private IPidePublicacion gestorPublicaciones;
    private GridBagConstraints ctes = new GridBagConstraints();
    private String applyButtonTextColor = "color: #ffffff;";
    private String applyButtonTextSize = "font-size: 12px;";
    private JButton publicar = new JButton("<html><span style=\""+applyButtonTextColor+applyButtonTextSize+"\">PUBLICAR</spam></html>");
    private JPanel panel;
    private ManagerGUI gui;

    public PublicacionesUsuarioGUI(ManagerGUI gui) {
        this.gui = gui;
        setPanelLayout();
    }

    // ############# Componentes visuales #############
    private void setPanelLayout(){
        this.panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        setResizable(false);

        this.getContentPane().setPreferredSize(new Dimension(700, 500));
        this.getContentPane().add(scrollPane);
        setTitle("Publicaciones");
        this.panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        this.panel.setBackground(Color.WHITE);
        setBounds(550,100,700,900);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void addButtons() {
        ctes.gridx = 1;
        ctes.gridy = 0;
        ctes.gridheight = 1;
        ctes.gridwidth = 1;
        ctes.weightx = 1.0;
        publicar.setBackground(new Color(12,86,206));
        publicar.setPreferredSize(new Dimension(150, 50));
        this.panel.add(publicar, ctes);
        publicar.addActionListener(this);
        reset();
    }

    // ############# Logica de la vista #############

     private void addPublications(JPanel panel) {
        //TODO cambiar el new y que ya esten instanciadas las publicaciones GUI al llamar al metodo y que lo que haga sea  coger publicacion 1 y situarla en el 0,1 , la dos y en el 0,2...
        this.gestorPublicaciones = App.getContoladorUsuario();
        List<IPublicacion> listPublicaciones = gestorPublicaciones.getPublicacionesPropias();
        for (int i = 0; i < listPublicaciones.size(); i++) {
            ctes.gridx = 0;
            ctes.gridy = i + 1;
            ctes.gridwidth = 3;
            ctes.gridheight = 1;
            ctes.weighty = 1.0;
            ctes.fill = GridBagConstraints.BOTH;
            panel.add(new PublicationGUI(listPublicaciones.get(i), this), ctes);
            reset();
        }
    }

    public void display(){
        addButtons();
        addPublications(panel);
        setVisible(true);
    }

    private void reset() {
        ctes.fill = GridBagConstraints.NONE;
        ctes.weightx = 0.0;
        ctes.weighty = 0.0;
    }

    public void updateGUI() {
        this.panel.removeAll(); this.gestorPublicaciones = App.getContoladorUsuario();
        display();
    }

    private List<IPublicacion> getPublicaciones() {
        java.util.List<IPublicacion> publicaciones;
        publicaciones = this.gestorPublicaciones.getPublicacionesPropias();
        return publicaciones;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == publicar) {
            WriteGUI writeGUI = new WriteGUI(gui);
            writeGUI.display();
        }
    }
}

