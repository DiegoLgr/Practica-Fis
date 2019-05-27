package es.upm.fis2019.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComentarioGUI extends JPanel implements ActionListener{

    private JButton answer = new JButton("RESPONDER");
    private JLabel label;

    private GridBagConstraints ctes = new GridBagConstraints();

    public ComentarioGUI(String text){
        this.label = new JLabel("<html><h4>"+text+"<h4><html>");
        addComponents();
        setVisible(true);
    }

    private void addComponents(){

        setLayout(new GridBagLayout());
        addLabel(label);
        addButton(answer);
        addActionEvent();
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

    private void addActionEvent()
    {
        answer.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==answer){
            //WriteGUI writeGUI = new WriteGUI("Respuesta");
        }
    }
}
