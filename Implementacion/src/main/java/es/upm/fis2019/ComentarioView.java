package es.upm.fis2019;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ComentarioView extends JPanel{

    private JButton answer = new JButton("RESPONDER");
    private JLabel label;

    private GridBagConstraints ctes = new GridBagConstraints();

    public ComentarioView(String text){
        this.label = new JLabel("<html><h2>"+text+"<h2><html>");
        addComponents();
        setVisible(true);
    }

    private void addComponents(){

        setLayout(new GridBagLayout());
        addLabel(label);
        addButton(answer);
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

    private void addButton(JButton button){
        ctes.gridx = 2;
        ctes.gridy = 1;
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
