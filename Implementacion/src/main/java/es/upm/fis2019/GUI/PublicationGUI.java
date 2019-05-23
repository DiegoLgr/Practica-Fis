package es.upm.fis2019.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublicationGUI extends JPanel implements ActionListener{

    private JLabel label;
    private String text;
    private JButton like = new JButton("LIKE");
    private JButton dislike = new JButton("DISLIKE");
    private JButton option = new JButton("OPTION");

    private GridBagConstraints ctes = new GridBagConstraints();

    public PublicationGUI(){
        setVisible(true);
    }

    public PublicationGUI(String text){
        this.text=text;
        label = new JLabel("<html><h2>"+this.text+"<h2><html>");
        addComponents();
        setVisible(true);
    }

    private void addActionEvent()
    {
        option.addActionListener(this);
        like.addActionListener(this);
        dislike.addActionListener(this);
    }

    public void setText(String text){
        this.text = text;
        label = new JLabel("<html><h2>"+this.text+"<h2><html>");
        addLabel(label);
    }

    public String getText() {
        return text;
    }

    private void addComponents(){

        setLayout(new GridBagLayout());
        addLabel(label);
        addButton(like,0);
        addButton(dislike,1);
        addButton(option,2);
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
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == option) {
            OpcionesPublicacionGUI opcionesPublicacionGUI= new OpcionesPublicacionGUI(this);
        }
    }
}
