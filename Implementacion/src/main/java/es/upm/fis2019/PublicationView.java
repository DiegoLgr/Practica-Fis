package es.upm.fis2019;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PublicationView extends JPanel {

    private JLabel label;
    private String text;
    private JButton like = new JButton("LIKE");
    private JButton dislike = new JButton("DISLIKE");
    private JButton option = new JButton("OPTION");

    private GridBagConstraints ctes = new GridBagConstraints();

    public PublicationView(){
        label = new JLabel("<html><h2>"+this.text+"<h2><html>");
        addLabel(label);
        setVisible(true);
    }

    public PublicationView(String text){
        label = new JLabel("<html><h2>"+text+"<h2><html>");
        addComponents();
        setVisible(true);
    }

    public void setText(String text){
        this.text = text;
    }

    private void addComponents(){

        setLayout(new GridBagLayout());
        addLabel(label);
        addButton(like,0);
        addButton(dislike,1);
        addButton(option,2);
        setBorder(new EmptyBorder(5,5,5,5));
    }

    private void addLabel(JLabel label){
        ctes.gridx=0;
        ctes.gridy=0;
        ctes.gridheight=3;
        ctes.gridwidth=2;
        ctes.weightx = 1.0;
        ctes.weighty = 1.0;
        ctes.fill = GridBagConstraints.BOTH;
        add(label,ctes);
        reset();
    }

    private void addButton(JButton button, int i){
        ctes.gridx = 2;
        ctes.gridy = i;
        ctes.gridwidth = 1;
        ctes.gridheight = 1;
        ctes.weighty = 1.0;
        add (button, ctes);
        reset();
    }

    private void reset(){
        ctes.fill = GridBagConstraints.NONE;
        ctes.weightx = 0.0;
        ctes.weighty = 0.0;
    }

}
