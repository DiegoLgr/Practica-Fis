package es.upm.fis2019;

import javax.swing.*;
import java.awt.*;

public class PublicationView extends JFrame {

    private String text = "Lorem ipsum dolor sit amet consectetur adipiscing elit, volutpat fames quam aliquet ac cras, curae varius vestibulum proin eleifend tempor. ";
    private JLabel label = new JLabel("<html>"+text+"<html>");
    private JButton like = new JButton("LIKE");
    private JButton dislike = new JButton("DISLIKE");

    private GridBagConstraints ctes = new GridBagConstraints();

    public PublicationView(){
        setSize(500,150);
        addComponents();
        setVisible(true);
    }

    public void setText(String text) {
        this.text = text;
    }

    private void addComponents(){
        this.getContentPane().setLayout(new GridBagLayout());
        addLabel(label);
        addButton(like, 0);
        addButton(dislike, 1);
    }

    private void addLabel(JLabel label){
        ctes.gridx=0;
        ctes.gridy=0;
        ctes.gridheight=2;
        ctes.gridwidth=2;
        ctes.weightx = 1.0;
        ctes.weighty = 1.0;
        ctes.fill = GridBagConstraints.BOTH;
        //this.getContentPane().add(label,ctes);
        this.getContentPane().add(label,ctes);
//        add(label,ctes);
        reset();
    }

    private void addButton(JButton button, int i){
        ctes.gridx = 2;
        ctes.gridy = i;
        ctes.gridwidth = 1;
        ctes.gridheight = 1;
        ctes.weighty = 1.0;
        this.getContentPane().add (button, ctes);
//        add(button,ctes);
        reset();
    }

    private void reset(){
        ctes.fill = GridBagConstraints.NONE;
        ctes.weightx = 0.0;
        ctes.weighty = 0.0;
    }

}
