package es.upm.fis2019.GUI;

import javax.swing.*;
import java.awt.*;

public class OpcionesPublicacionGUI extends JFrame{

    private JButton borrar = new JButton("BORRAR");
    private JButton comentar = new JButton("COMMENT");
    private String text;
    private GridBagConstraints ctes = new GridBagConstraints();

    public OpcionesPublicacionGUI(PublicationGUI publicationGUI){
        this.text= publicationGUI.getText();
        this.getContentPane().setLayout(new GridBagLayout());
        addButtons();
        addPublication();
        addComments();
        setView();
    }

    private void addButtons(){

        for(int i=0;i<2;i++){
            JButton button = new JButton("text " + i);
            ctes.gridx=3*i;
            ctes.gridy=0;
            ctes.gridwidth=3;
            ctes.gridheight=1;
            ctes.weighty = 1.0;
            ctes.weightx = 3.0;
            this.getContentPane().add(button,ctes);
            reset();
        }
    }

    private void setView(){
        setTitle(getTitle());
        setVisible(true);
        setBounds(720,10,500,900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
    }

    private void addPublication(){
        JLabel label = new JLabel("<html><h2>"+this.text+"<h2><html>");
        ctes.gridx=0;
        ctes.gridy=1;
        ctes.gridwidth=6;
        ctes.gridheight=1;
        ctes.weighty = 1.0;
        ctes.fill = GridBagConstraints.BOTH;
        this.getContentPane().add(label,ctes);
        reset();
    }

    private void addComments(){
        String text = "Lorem ipsum dolor sit amet consectetur adipiscing elit, volutpat fames quam aliquet ac cras, curae varius vestibulum proin eleifend tempor. ";
        for(int i=0; i<5; i++){
            ctes.gridx=0;
            ctes.gridy=i+2;
            ctes.gridwidth=6;
            ctes.gridheight=1;
            ctes.weighty = 1.0;
            ctes.fill = GridBagConstraints.BOTH;
            this.getContentPane().add(new ComentarioGUI(text), ctes);
            reset();
        }
    }

    private void reset(){
        ctes.fill = GridBagConstraints.NONE;
        ctes.weightx = 0.0;
        ctes.weighty = 0.0;
    }






}
